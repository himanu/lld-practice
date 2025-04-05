package llds.elevatorV1.strategies;

import llds.elevatorV1.entities.Elevator;
import llds.elevatorV1.entities.Request;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

// Elevator movement logic run on a separate single thread
// while there are multiple thread which accept floor change request.
// These multiple threads add incoming request to the queue,
// when the movement logic thread go in wait state,
// and when a new request comes in, the movm logic thread is notified, and it wakes up
// start processing the request,

// So by the time the logic thread woke up, the request has been pushed to queue
// the main method is notified and it got all requests but it's notified for one request
// so it has read those insert too.
//


/** Important Conclusion */
// i wanna talk about wait and notify also.
// 1. both of these are invoked in a synchronised context.
// 2. And they needs to synchorized on the same object, otherwise the communication won't happen
// 3. For eg: If notify synchronous blocks locks on this object and wait synchronous blocks locks on a
//    separate object then the communication won't happen


public class
DefaultElevatorMovement implements ElevatorMovement {
    private final Queue<Request> requests;
    private volatile Elevator elv;

    public DefaultElevatorMovement() {
        requests = new ConcurrentLinkedQueue<>(); // Thread-safe queue
        new Thread(this::activateElevator, "me").start(); // Start processing thread
    }

    @Override
    public void processRequest(Request req, Elevator el) {
        requests.add(req); // Directly add request without synchronization
        this.elv = el;
        System.out.println("size " + requests.size() + " " + el.getId());
        synchronized (this) { // Notify only when necessary
            System.out.println("Going to notifying");
            this.notify();
        }
    }

    private void activateElevator() {
        Request req;
        synchronized (this) {
            while (requests.isEmpty()) {
                try {
                    System.out.println("Wait1");
                    this.wait(); // Wait until new requests arrive
                    System.out.println("Wake up " + requests.size());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            while (!requests.isEmpty()) {
                req = requests.poll(); // Remove the request safely
                elv.moveElevator(req.getFloor());

                while (requests.isEmpty()) {
                    System.out.println("Wait2");
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }
    }
}

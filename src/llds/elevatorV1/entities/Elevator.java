package llds.elevatorV1.entities;

import llds.elevatorV1.strategies.ElevatorMovement;

public class Elevator {
    ElevatorMovement elevatorMovement;
    int id;
    int currentFloor;
    Directions direction;

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getId() {
        return id;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    public Elevator(int id, ElevatorMovement elevatorMovement) {
        this.id = id;
        this.elevatorMovement = elevatorMovement;
        this.currentFloor = 0;
        this.direction = Directions.IDLE;
    }

    public void processRequest(Request req) {
        elevatorMovement.processRequest(req, this);
    }

    public void moveElevator(int floor) {
        if (currentFloor != floor) {
            System.out.println("Moving from " + currentFloor + " to " + floor);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            currentFloor = floor;
            System.out.println("Reached floor " + floor);
            this.direction = Directions.IDLE;
        } else
            System.out.println("Elevator already present on the floor");
        System.out.println("=================");
    }

}

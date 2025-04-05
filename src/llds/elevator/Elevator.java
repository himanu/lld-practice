package llds.elevator;

import java.util.*;

public class Elevator {
    int direction;
    int nextTarget;
    int currentFloor;
    NavigableSet<Integer> up;
    NavigableSet<Integer> down;

    public Elevator() {
        up = new TreeSet<>();
        down = new TreeSet<>();
        currentFloor = 0;
        nextTarget = -1;
        direction = 0;
    }

    public void enterRequest(int floor, int direction) {
        if (direction == 1) {
            up.add(floor);
        } else {
            down.add(floor);
        }
        if (this.direction == 1) {
            if (floor < nextTarget && floor > currentFloor && direction == 1)
                nextTarget = floor;
        } else if(this.direction == -1) {
            if (floor > nextTarget && floor < currentFloor && direction == -1)
                nextTarget = floor;
        }
        if (this.direction == 0) {
            if (floor > currentFloor) {
                direction = 1;
                nextTarget = floor;
            } else if(floor < currentFloor){
                direction = -1;
                nextTarget = floor;
            }
            notify();
        }
    }

    synchronized public void startElevator() throws InterruptedException {
        while(direction == 0) {
            wait();
        }
        while(direction != 0) {
            while (direction == 1) {
                while (currentFloor != nextTarget) {
                    currentFloor += 1;
                    System.out.println("Reached floor " + currentFloor);
                    if (currentFloor == nextTarget) {
                        System.out.println("STOP");
                        if (up.ceiling(currentFloor) != null) {
                            nextTarget = up.ceiling(currentFloor);
                        } else {

                        }
                        up.remove(currentFloor);
                        Thread.sleep(1000);
                        System.out.println("Start");
                    }
                    System.out.println("==================");
                }

                // now let's see if there is any other element in the down
                if (down.last() > currentFloor) {
                    nextTarget = currentFloor;
                } else {
                    nextTarget = down.last();
                    direction = -1;
                }
            }

            while(direction == -1) {
                while(currentFloor != nextTarget) {
                    currentFloor -= 1;
                    System.out.println("Reached floor " + currentFloor);
                    if (currentFloor == nextTarget) {
                        System.out.println("STOP");
                        if (down.lower(currentFloor) != null) {
                            nextTarget = down.lower(currentFloor);
                        }
                        down.remove(currentFloor);
                        Thread.sleep(1000);
                        System.out.println("Start");
                    }
                }

                if (up.first() < currentFloor) {
                    nextTarget = up.first();
                } else {
                    if (!up.isEmpty()) {
                        direction = 1;
                        nextTarget = up.first();
                    } else if (!down.isEmpty()) {
                        direction = 1;
                        nextTarget = down.last();
                    } else
                        direction = 0;
                }
            }
        }

    }

}

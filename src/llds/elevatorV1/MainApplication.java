package llds.elevatorV1;

import llds.elevatorV1.entities.Directions;
import llds.elevatorV1.entities.Elevator;
import llds.elevatorV1.entities.Request;
import llds.elevatorV1.strategies.DefaultElevatorMovement;
import llds.elevatorV1.strategies.DefaultElevatorSelection;
import llds.elevatorV1.strategies.ElevatorSelection;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {

    public static void main(String[] args) {

        ElevatorSelection defaultSelection = new DefaultElevatorSelection();
        ElevatorSystem elevatorSystemObj = new ElevatorSystem(defaultSelection);

        Elevator el1 = new Elevator(1, new DefaultElevatorMovement());
        Elevator el2 = new Elevator(2, new DefaultElevatorMovement());
        elevatorSystemObj.addElevator(el1);
        elevatorSystemObj.addElevator(el2);
        Thread t1 = new Thread(() -> elevatorSystemObj.acceptRequest(new Request(Directions.DOWN, 2)));

        Thread t2 = new Thread(() -> elevatorSystemObj.acceptRequest(new Request(Directions.UP, 3)));

        Thread t3 = new Thread(() -> el1.processRequest(new Request(Directions.DOWN, 3)));
        Thread t4 = new Thread(() -> el1.processRequest(new Request(Directions.DOWN, 4)));


        t2.start();
        t3.start();
        t4.start();
        t1.start();
    }
}

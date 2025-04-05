package llds.elevatorV1;

import llds.elevatorV1.entities.Elevator;
import llds.elevatorV1.entities.Request;
import llds.elevatorV1.strategies.ElevatorSelection;

import java.util.LinkedList;
import java.util.List;

public class ElevatorSystem {
    List<Elevator> elevatorList;
    ElevatorSelection elevatorSelection;

    public ElevatorSystem(ElevatorSelection elevatorSelection) {
        this.elevatorList = new LinkedList<>();
        this.elevatorSelection = elevatorSelection;
    }

    public void addElevator(Elevator elevator) {
        elevatorList.add(elevator);
    }

    public void acceptRequest(Request req) {
        Elevator el = elevatorSelection.getElevator(req, elevatorList);
        el.processRequest(req);
    }


}

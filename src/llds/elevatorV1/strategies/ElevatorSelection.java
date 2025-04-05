package llds.elevatorV1.strategies;

import llds.elevatorV1.entities.Elevator;
import llds.elevatorV1.entities.Request;

import java.util.List;

public interface ElevatorSelection {
    Elevator getElevator(Request req, List<Elevator> elevatorList);
}

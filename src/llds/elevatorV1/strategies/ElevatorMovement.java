package llds.elevatorV1.strategies;

import llds.elevatorV1.entities.Elevator;
import llds.elevatorV1.entities.Request;

public interface ElevatorMovement {
    void processRequest(Request req, Elevator el);
}

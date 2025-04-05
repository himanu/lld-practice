package llds.elevatorV1.strategies;

import llds.elevatorV1.entities.Directions;
import llds.elevatorV1.entities.Elevator;
import llds.elevatorV1.entities.Request;

import java.util.List;

public class DefaultElevatorSelection implements ElevatorSelection{
    @Override
    public Elevator getElevator(Request req, List<Elevator> elevatorList) {
        Elevator el = elevatorList.stream().filter((elevator) ->
                (elevator.getDirection()) == Directions.IDLE
        ).findFirst().orElse(elevatorList.get(0));

        return el;
    }
}

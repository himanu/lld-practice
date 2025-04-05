package llds.elevatorV1.entities;

public class Request {
    Directions direction;
    int floor;

    public Request(Directions direction, int floor) {
        this.direction = direction;
        this.floor = floor;
    }
    public int getFloor() {
        return  floor;
    }
}

package ru.job4j.oop;

public class UsageTransport {
    public static void main(String[] args) {
        Airplane airplane = new Airplane();
        AirplaneAdditionally airplaneAdditionally = new AirplaneAdditionally();
        Bus bus = new Bus();
        BusAdditionally busAdditionally = new BusAdditionally();
        Train train = new Train();
        TrainAdditionally trainAdditionally = new TrainAdditionally();

        Vehicle[] vehicles = new Vehicle[] {airplane, airplaneAdditionally, bus, busAdditionally, train, trainAdditionally};
        for (Vehicle item: vehicles) {
            item.move();
            item.passengers();
        }
    }
}

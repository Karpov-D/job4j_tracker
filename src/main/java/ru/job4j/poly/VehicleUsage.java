package ru.job4j.poly;

public class VehicleUsage {
    public static void main(String[] args) {
        Vehicle bus = new Bus_2();
        Vehicle train = new Train();
        Vehicle plane = new Plane();

        Vehicle[] vehicles = new Vehicle[]{bus, train, plane};
        for (Vehicle v : vehicles) {
            v.move();
            v.fuel();
        }

    }
}

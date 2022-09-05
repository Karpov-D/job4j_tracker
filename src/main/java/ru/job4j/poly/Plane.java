package ru.job4j.poly;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает.");

    }

    @Override
    public void fuel() {
        System.out.println(getClass().getSimpleName() + " заправляется керосином.");
    }
}

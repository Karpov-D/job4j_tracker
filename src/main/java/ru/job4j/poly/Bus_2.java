package ru.job4j.poly;

public class Bus_2 implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " едет по трассе.");
    }

    @Override
    public void fuel() {
        System.out.println(getClass().getSimpleName() + " заправляется дизельным топливом.");
    }
}

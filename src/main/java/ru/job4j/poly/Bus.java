package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {

    }

    @Override
    public void passengers(int countPassenger) {
        int countPass = 0;
        if (countPassenger > 0 || countPass - countPassenger >= 0) {
            countPass += countPassenger;
        }

    }

    @Override
    public int refuel(int countFuel) {
        int price = countFuel * 55;
        return price;
    }
}

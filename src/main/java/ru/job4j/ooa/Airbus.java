package ru.job4j.ooa;

public final class Airbus extends Aircraft {
    private final static int COUNT_ENGINE = 2;
    private final static int COUNT_ENGINE_A380 = 4;
    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        int numberOfEngine = ("A380".equals(name) ? COUNT_ENGINE_A380 : COUNT_ENGINE);
        System.out.println("Количество двигателей равно: " + numberOfEngine);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}


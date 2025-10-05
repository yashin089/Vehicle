package ru.homework3;

public non-sealed class Bicycle extends Transport {

    public Bicycle(String model, String year) {
        super(model, year);
    }

    @Override
    public void get_info() {
        super.get_info();
    }

    @Override
    public void move() {
        System.out.println("Велосипед катится");
    }

    @Override
    public void stop() {
        System.out.println("Велосипед останавливается");
    }
}

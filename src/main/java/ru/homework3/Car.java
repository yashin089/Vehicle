package ru.homework3;

public non-sealed class Car extends Transport {

    public Car(String model, String year) {
        super(model, year);
    }

    @Override
    public void get_info() {
        super.get_info();
    }

    @Override
    public void move() {
        System.out.println("Автомобиль двигается");
    }

    @Override
    public void stop() {
        System.out.println("Автомобиль останавливается");
    }
}

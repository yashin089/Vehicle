package ru.homework3;

public non-sealed class Ship extends Transport {

    public Ship(String model, String year) {
        super(model, year);
    }

    @Override
    public void get_info() {
        super.get_info();
    }

    @Override
    public void move() {
        System.out.println("Корабль плывет");
    }

    @Override
    public void stop() {
        System.out.println("Корабль останавливается");
    }

}

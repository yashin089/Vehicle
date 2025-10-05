package ru.homework3;

public non-sealed class Plane extends Transport {

    public Plane(String model, String year) {
        super(model, year);
    }

    @Override
    public void get_info() {
        super.get_info();
    }

    @Override
    public void move() {
        System.out.println("Самолет летит");
    }

    @Override
    public void stop() {
        System.out.println("Самолет останавливается");
    }
}

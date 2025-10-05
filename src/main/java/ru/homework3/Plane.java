package ru.homework3;

public non-sealed class Plane extends Transport {

    final private Engine engine;

    public Plane(String model, String year, Engine engine) {
        super(model, year);
        this.engine = engine;
    }

    @Override
    public void get_info() {
        super.get_info();
        engine.get_info();
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

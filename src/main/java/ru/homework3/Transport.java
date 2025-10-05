package ru.homework3;

public sealed abstract class Transport implements Movable permits Car, Plane, Ship, Bicycle{

    private String model;
    private String year;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Transport(String model, String year) {
        this.model = model;
        this.year = year;
    }

    public void get_info() {
        System.out.println("Модель: " + model);
        System.out.println("Год выпуска: " + year);
    }

}

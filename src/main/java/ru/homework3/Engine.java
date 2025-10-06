package ru.homework3;

public class Engine implements Infoable {
    private String model;
    private TypeEngine engineType;
    private double power;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public TypeEngine getEngineType() {
        return engineType;
    }

    public void setEngineType(TypeEngine engineType) {
        this.engineType = engineType;
    }

    public double getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Engine(String model, TypeEngine engineType, double power) {
        this.model = model;
        this.engineType = engineType;
        this.power = power;
    }

    @Override
    public void get_info() {
        System.out.println("Модель двигателя: " + model);
        System.out.println("Тип двагателя: " + engineType.toString());
        System.out.println("Мощность двигателя: " + power);
    }

}

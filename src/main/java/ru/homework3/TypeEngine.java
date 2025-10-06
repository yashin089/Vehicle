package ru.homework3;

public enum TypeEngine {
    PETROL ("Бензиновый"),
    DIESEL ("Дизельный"),
    JET_ENGINES ("Реактивный");

    private String description;

    TypeEngine(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}

package ru.homework3;

public enum ConsoleCommand {
    CREATE_BICYCLE ("1"),
    CREATE_CAR ("2"),
    CREATE_PLANE ("3"),
    CREATE_SHIP ("4"),
    EXIT ("exit");

    private final String value;

    ConsoleCommand(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static ConsoleCommand findByValue(String value) throws NullCommandException {
        ConsoleCommand result = null;
        for (ConsoleCommand command : values()) {
            if (command.getValue().equals(value)) {
                result = command;
                break;
            }
        }
        if (result != null){
            return result;
        } else {
            throw new NullCommandException("Не удалось определить команду");
        }

    }
}

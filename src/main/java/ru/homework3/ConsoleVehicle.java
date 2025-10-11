package ru.homework3;

import java.util.Scanner;

public class ConsoleVehicle {

    private final Scanner scanner;

    private ConsoleCommand command;

    public ConsoleVehicle(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {

        boolean isNoShowInf = false;    //Флаг, чтобы не показывать сообщене о запросе значения
        boolean isExit = false;     //Флаг для команды Выход

        information();

        do {
            //Запрашиваем выражение от пользователя
            if (getExpression(isNoShowInf)) {
                if (command == ConsoleCommand.EXIT) {
                    isExit = true;
                } else {
                    try {
                        Transport transport = getTransportByCommand(command);
                        transport.get_info();
                        transport.move();
                        transport.stop();
                        isNoShowInf = false;
                    } catch (NullTransportByCommand e) {
                        System.out.println(e.getMessage());
                        System.out.println("Что-то пошло не так, обратитесь в поддержку");
                        return;
                    }
                }
            } else {    //Если не удалось получить корректное выражение
                System.out.println("Неверное выражение. Введите еще раз:");
                isNoShowInf = true;
            }
        } while (!isExit); //Выполняем цикл пока не получим команду exit
    }

    private void information() {

        System.out.println("Демонстрация работы 4 видов транспорта.");
        System.out.println("Для получения результата введите выражение.");
        System.out.println("Например: 1");
        System.out.println("Доступные операции:");
        System.out.println("1 - Создание велосипеда");
        System.out.println("2 - Создание машины");
        System.out.println("3 - Создание свмолета");
        System.out.println("4 - Создание корабля");
        System.out.println("Для выхода из программы введите команду ( exit )");

    }

    private boolean getExpression(boolean isNoShowInf) {

        if (!isNoShowInf) {
            System.out.println("Введите выражение:");
        }

        //Запрашиваем выражение от пользователя
        String expression = scanner.nextLine();

        try {
            command = ConsoleCommand.findByValue(expression);
            return true;
        } catch (NullCommandException e) {
            return false;
        }
    }

    private Transport getTransportByCommand(ConsoleCommand command) throws NullTransportByCommand {
        return switch (command) {
            case CREATE_BICYCLE -> new Bicycle("ACID 29", "2014");
            case CREATE_CAR -> new Car("Audi A4 B9", "2025",
                    new Engine("EA888 GEN5", TypeEngine.PETROL, 190));
            case CREATE_PLANE -> new Plane("МС-21-310", "2025",
                    new Engine("ПД-14", TypeEngine.JET_ENGINES, 14000));
            case CREATE_SHIP -> new Ship("Сухогруз проекта RSD59", "2025",
                    new Engine("6L20", TypeEngine.DIESEL, 3000));
            default -> throw new NullTransportByCommand("Не удалось создать нужный транспорт по команде");
        };
    }

}

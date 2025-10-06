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
                    Transport transport = getTransportByCommand(command);
                    transport.get_info();
                    isNoShowInf = false;
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

        command = ConsoleCommand.findByValue(expression);
        if (command != null) {
            return true;
        } else {
            return false;
        }
    }

    private Transport getTransportByCommand(ConsoleCommand command) {
        return switch (command) {
            case CREATE_BICYCLE:
                yield new Bicycle("ACID 29", "2014");
            case CREATE_CAR:
                yield new Car("Audi A4 B9", "2025",
                        new Engine("EA888 GEN5", TypeEngine.PETROL, 190));
            case CREATE_PLANE:
                yield new Plane("МС-21-310", "2025",
                        new Engine("ПД-14", TypeEngine.JET_ENGINES, 14000));
            case CREATE_SHIP:
                yield new Ship("Сухогруз проекта RSD59", "2025",
                        new Engine("6L20", TypeEngine.DIESEL, 3000));
            default:
                yield null;
        };
    }

}

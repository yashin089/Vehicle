package ru.homework3;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ConsoleVehicle vehicle = new ConsoleVehicle(scanner);
        vehicle.run();
        scanner.close();

    }
}
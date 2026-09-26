package ru.university.lab2.util;
import ru.university.lab2.arrays.Task05Arrays1D;
import ru.university.lab2.arrays.Task06Arrays2D;
import ru.university.lab2.numbers.Task01Integers;
import ru.university.lab2.numbers.Task02FloatPoint;
import ru.university.lab2.numbers.Task03Bitwise;
import ru.university.lab2.strings.Task04TextProcessing;

import java.util.Scanner;

public class Task08Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void run() {
        printHelp();
        boolean running = true;
        do {
            printMenu();
            int choice = readMenuChoice();
            running = handleChoice(choice);
        } while (running);
        System.out.println("Работа программы завершена.");
    }


    private static void printHelp() {
        String help = """
                Лабораторная работа №2. Типы данных, строки и массивы.
                Выберите номер задания в меню, чтобы посмотреть демонстрацию.
                Пункт 0 завершает программу.
                """;
        System.out.println(help);
    }

    private static void printMenu() {
        System.out.println("""

                Меню
                1 - Целочисленные ловушки
                2 - Вещественная арифметика
                3 - Побитовые операции
                4 - Обработка текста
                5 - Одномерные массивы
                6 - Многомерные массивы
                7 - Методы и передача аргументов
                0 - Выход
                Ваш выбор:""");
    }

    private static int readMenuChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Некорректный ввод. Введите число из меню.");
            scanner.next(); // "съедаем" некорректный токен (например, слово из букв)
            System.out.print("Ваш выбор: ");
        }
        return scanner.nextInt();
    }


    private static boolean handleChoice(int choice) {
        switch (choice) {
            case 1 -> Task01Integers.run();
            case 2 -> Task02FloatPoint.run();
            case 3 -> Task03Bitwise.run();
            case 4 -> Task04TextProcessing.run();
            case 5 -> Task05Arrays1D.run();
            case 6 -> Task06Arrays2D.run();
            case 7 -> Task07Methods.run();
            case 0 -> {
                return false;
            }
            default -> System.out.println("Такого пункта меню нет, число должно быть от 0 до 7.");
        }
        return true;
    }


}

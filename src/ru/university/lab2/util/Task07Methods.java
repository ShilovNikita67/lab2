package ru.university.lab2.util;

public class Task07Methods {
    public static void run() {
        overloadingDemo();
        varargsDemo();
        powerDemo();
    }

    private static void print(int value) {
        System.out.println("print(int): " + value);
    }

    private static void print(double value) {
        System.out.println("print(double): " + value);
    }

    private static void print(String value) {
        System.out.println("print(String): " + value);
    }

    private static void print(int[] value) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < value.length; i++) {
            sb.append(value[i]);
            if (i < value.length - 1) sb.append(", ");
        }
        sb.append("]");
        System.out.println("print(int[]): " + sb);
    }

    private static void overloadingDemo() {
        System.out.println("=== 7.1 Перегрузка методов ===");
        print(42);                 // вызовется print(int)
        print(3.14);                // вызовется print(double)
        print("hello");             // вызовется print(String)
        print(new int[]{1, 2, 3});  // вызовется print(int[])
        // Компилятор выбирает нужную перегрузку по статическому типу
        // аргумента (сигнатуре вызова), а не по значению в рантайме.
    }

    private static int sum(int... numbers) {
        int total = 0;
        for (int n : numbers) {
            total += n;
        }
        return total;
    }

    private static void varargsDemo() {
        System.out.println("\n=== 7.2 varargs ===");
        System.out.println("sum() = " + sum());                 // ноль аргументов
        System.out.println("sum(1,2,3,4,5) = " + sum(1, 2, 3, 4, 5));
        int[] array = {10, 20, 30};
        System.out.println("sum(array) = " + sum(array));       // передача готового массива
        // varargs под капотом — это обычный массив: "int... numbers" эквивалентно
        // "int[] numbers" внутри метода, поэтому в него можно передать как
        // перечисление значений через запятую, так и готовый массив.
    }

    private static double powerRecursive(double base, int exponent) {
        if (exponent == 0) {
            return 1.0;
        }
        return base * powerRecursive(base, exponent - 1);
    }

    private static double powerIterative(double base, int exponent) {
        double result = 1.0;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    private static void powerDemo() {
        System.out.println("\n=== 7.3 Степень: рекурсивно и итеративно ===");
        double[] bases = {2, 5, 10};
        int[] exponents = {0, 1, 5, 10};

        for (double base : bases) {
            for (int exp : exponents) {
                double recursive = powerRecursive(base, exp);
                double iterative = powerIterative(base, exp);
                double expected = Math.pow(base, exp);
                System.out.printf("base=%.1f exp=%d -> recursive=%.2f iterative=%.2f Math.pow=%.2f%n",
                        base, exp, recursive, iterative, expected);
            }
        }

        System.out.println("\n=== 7.4 Какая реализация быстрее (рассуждение) ===");
        System.out.println("""
                Итеративная реализация должна работать быстрее рекурсивной.
                При каждом рекурсивном вызове powerRecursive JVM создаёт новый
                кадр стека вызовов: сохраняет адрес возврата, параметры и
                локальные переменные метода, а после завершения вызова эти
                данные снимаются со стека. Это дополнительные затраты времени
                и памяти на каждый из exponent вложенных вызовов.
                Итеративная версия использует один и тот же кадр стека на
                протяжении всего цикла и не выполняет ничего, кроме самого
                умножения, поэтому накладных расходов на вызовы у неё нет.
                """);
    }

}

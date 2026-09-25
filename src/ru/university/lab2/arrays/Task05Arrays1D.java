package ru.university.lab2.arrays;

import java.util.Arrays;
import java.util.Random;

public class Task05Arrays1D {
    public static void run() {
        int[] numbers = createRandomArray(10);
        printMinMaxAverage(numbers);
        sortAndPrint(numbers);
        compareArrays();
    }

    private static int[] createRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100); // 0..99
        }
        return array;
    }

    private static void printMinMaxAverage(int[] array) {
        System.out.println("=== 5.1-5.2 Массив, минимум, максимум, среднее ===");
        System.out.println("Массив: " + toStringManual(array));

        int min = array[0];
        int max = array[0];
        long sum = 0;
        for (int value : array) {
            if (value < min) min = value;
            if (value > max) max = value;
            sum += value;
        }
        double average = (double) sum / array.length;
        System.out.println("min=" + min + " max=" + max + " average=" + average);
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break; // массив уже отсортирован, дальнейшие проходы не нужны
            }
        }
    }

    private static void sortAndPrint(int[] numbers) {
        System.out.println("\n=== 5.3 Сортировка пузырьком ===");
        int[] copy = numbers.clone();
        System.out.println("До:    " + toStringManual(copy));
        bubbleSort(copy);
        System.out.println("После: " + toStringManual(copy));
    }

    private static void compareArrays() {
        System.out.println("\n=== 5.4 Сравнение массивов ===");
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = arr1;

        System.out.println("arr1 == arr2          : " + (arr1 == arr2));
        System.out.println("arr1 == arr3          : " + (arr1 == arr3));
        System.out.println("arr1.equals(arr2)     : " + arr1.equals(arr2));
        System.out.println("Arrays.equals(arr1,arr2): " + Arrays.equals(arr1, arr2));
        // arr1 == arr2 сравнивает ссылки — это разные объекты в куче, поэтому false,
        // даже если их содержимое совпадает.
        // arr1 == arr3 сравнивает ссылки, но arr3 — это та же самая ссылка, что и arr1,
        // поэтому true.
        // Массивы не переопределяют equals(), поэтому arr1.equals(arr2) фактически
        // выполняет то же самое сравнение ссылок, что и ==, — тоже false.
        // Arrays.equals сравнивает массивы поэлементно и корректно возвращает true.
    }

    private static String toStringManual(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }

}

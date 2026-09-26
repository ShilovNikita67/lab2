package ru.university.lab2.arrays;

import java.util.Random;

public class Task06Arrays2D {
    public static void run() {
        int[][] matrix = createMatrix(3, 4);
        System.out.println("=== 6.1 Матрица M x N ===");
        printMatrix(matrix);

        System.out.println("\n=== 6.2 Транспонирование ===");
        int[][] transposed = transpose(matrix);
        printMatrix(transposed);

        System.out.println("\n=== 6.3 Умножение матриц ===");
        int[][] a = {{1, 2, 3}, {4, 5, 6}};       // 2x3
        int[][] b = {{7, 8}, {9, 10}, {11, 12}};  // 3x2
        int[][] product = multiply(a, b);
        System.out.println("A:");
        printMatrix(a);
        System.out.println("B:");
        printMatrix(b);
        System.out.println("A x B:");
        printMatrix(product);

        System.out.println("\nПопытка умножить несогласованные матрицы:");
        int[][] c = {{1, 2}, {3, 4}}; // 2x2
        multiply(a, c); // a: 2x3, c: 2x2 -> число столбцов a (3) != число строк c (2)
    }

    private static int[][] createMatrix(int rows, int cols) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(100);
            }
        }
        return matrix;
    }

    // Вывод матрицы в виде таблицы с выравниванием
    private static void printMatrix(int[][] matrix) {
        if (matrix == null) {
            System.out.println("(нет матрицы)");
            return;
        }
        for (int[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            for (int value : row) {
                sb.append(String.format("%5d", value));
            }
            System.out.println(sb);
        }
    }

    private static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    private static int[][] multiply(int[][] a, int[][] b) {
        int aRows = a.length;
        int aCols = a[0].length;
        int bRows = b.length;
        int bCols = b[0].length;

        if (aCols != bRows) {
            System.out.println("Умножение невозможно: число столбцов A (" + aCols
                    + ") не совпадает с числом строк B (" + bRows + ")");
            return null;
        }

        int[][] result = new int[aRows][bCols];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++) {
                int sum = 0;
                for (int k = 0; k < aCols; k++) {
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

}

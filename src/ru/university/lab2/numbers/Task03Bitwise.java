package ru.university.lab2.numbers;

public class Task03Bitwise {
    public static void run(){
        bitwiseOperatorsDemo();
        negativeDemo();
        bitTricksDemo();
        swapViaXorDemo();
    }
    private static void bitwiseOperatorsDemo(){
        int a = 12;
        int b = 10;
        System.out.println("a&b: " + (a&b));
        System.out.println("a|b: " + (a|b));
        System.out.println("a^b: " + (a^b));
        System.out.println("~a: " + (~a));
        System.out.println("<<2: " + (a<<2));
        System.out.println(">>2: " + (a>>2));
        System.out.println(">>>2: " + (a>>>2));
    }
    private static void negativeDemo(){
        int negative = -12;
        System.out.println("negative >> 2: " + (negative >> 2));
        System.out.println("negative >>> 2: " + (negative >>> 2));
        // >> - арифметический сдвиг: освобождающиеся слева биты заполняются
        // значением знакового бита, поэтому знак числа сохраняется
        // (отрицательное остаётся отрицательным).
        // >>> - логический сдвиг: освобождающиеся биты всегда заполняются
        // нулями, поэтому у отрицательного числа результат становится
        // большим положительным — знаковый бит перестаёт быть знаковым.
    }
    private static boolean isEven(int n) {
        // Младший бит числа равен 1 тогда и только тогда, когда число нечётное.
        return (n & 1) == 0;
    }

    private static boolean isPowerOfTwo(int n) {
        // У степени двойки установлен ровно один бит (например, 8 = 1000).
        // n & (n - 1) обнуляет младший установленный бит; если результат 0,
        // значит установленный бит был ровно один. Отдельно исключаем n <= 0.
        return n > 0 && (n & (n - 1)) == 0;
    }

    private static int countSetBits(int n) {
        int count = 0;
        int value = n;
        while (value != 0) {
            count += value & 1;
            value >>>= 1; // логический сдвиг, чтобы корректно дойти до 0 и для отрицательных n
        }
        return count;
    }

    private static void bitTricksDemo() {
        System.out.println("\n=== 3.3 Чётность / степень двойки / количество бит ===");
        int[] samples = {7, 8, 16, 18, -5};
        for (int n : samples) {
            System.out.println("n=" + n
                    + " even=" + isEven(n)
                    + " powerOfTwo=" + isPowerOfTwo(n)
                    + " setBits=" + countSetBits(n));
        }
    }
    private static void swapViaXorDemo() {
        System.out.println("\n=== 3.4 Обмен значений через XOR ===");
        int x = 5, y = 9;
        System.out.println("до: x=" + x + " y=" + y);
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("после: x=" + x + " y=" + y);
        // Идея: x^=y "запоминает" в x информацию об обоих числах.
        // y^=x (новый x) восстанавливает в y исходное значение x.
        // x^=y (новый y, то есть исходный x) восстанавливает в x исходное y.
    }


}

package ru.university.lab2.numbers;

public class Task02FloatPoint {
    public static void run(){
        sumRoundingError();
        repeatedAdditionVsOne();
        epsilonDemo();
        specialValues();
        roundingComparison();
        floatVsDouble();
    }


    private static void sumRoundingError(){
        double sum = 0.1+0.2;
        System.out.println("Сумма 0.1 + 0.2: "+sum);
        // 0.1 и 0.2 не представимы точно в двоичной системе с плавающей точкой
        // (как 1/3 не представима точно в десятичной), поэтому хранятся с
        // небольшой погрешностью округления. Их сумма — тоже приближённое
        // значение, которое лишь очень близко к 0.3, но не равно ему.
    }
    private static void repeatedAdditionVsOne(){
        double sum = 0;
        for(int i = 0; i<=10; i++) {
            sum+=0.1;
        }
        System.out.println("Сумма: "+ sum);
        boolean res = sum == 1.0;
        System.out.println("Результат == : " + res);
        // Каждое сложение накапливает свою погрешность округления,
        // поэтому результат отличается от 1.0 на очень маленькую величину.
    }
    private static boolean almostEqual(double a, double b, double epsilon){
        return Math.abs(a-b)<epsilon;
    }
    private static void epsilonDemo(){
        double sum = 0.0;
        for (int i=0; i<10; i++){
            sum+=0.1;
        }
        double epsilon = 1e-9;
        System.out.println(almostEqual(sum,1.0,epsilon));
    }
    private static void specialValues(){
        double posInf = 1.0 / 0.0;
        double negInf = -1.0 / 0.0;
        double nan = 0.0 / 0.0;
        System.out.println("1.0 / 0.0  = " + posInf);
        System.out.println("-1.0 / 0.0 = " + negInf);
        System.out.println("0.0 / 0.0  = " + nan);
        System.out.println("NaN != NaN : " + (nan != nan));
        // NaN по стандарту IEEE 754 не равен даже самому себе — это единственное
        // значение double, для которого x != x истинно. Отсюда следует, что
        // для проверки "является ли число NaN" нужно использовать Double.isNaN,
        // а не сравнение с ==.
    }
    private static void roundingComparison(){
        double[] values = {2.7, -2.7, 2.5, -2.5};
        for (double v: values){
            System.out.println(v+" "+ (int)v + " " + Math.round(v) + " " + Math.floor(v)+ " " + Math.ceil(v));
            // (int) всегда отбрасывает дробную часть (округление к нулю), поэтому
            // (int) -2.7 = -2, а не -3.
            // Math.round всегда округляет к ближайшему большему при "ровно .5"
            // (round(2.5) = 3, но round(-2.5) = -2, а не -3) — округление
            // выполняется через floor(x + 0.5).
            // Math.floor всегда даёт ближайшее меньшее целое (в сторону -inf),
            // Math.ceil — ближайшее большее (в сторону +inf), независимо от знака.
        }
    }
    private static void floatVsDouble(){
        float floatRes = 1f / 3f;
        double doubleRes = 1.0 / 3.0;
        System.out.println("float: " + floatRes);
        System.out.println("double: " + doubleRes);
        // float хранит число в 32 битах (около 7 значащих десятичных цифр),
        // double — в 64 битах (около 15-16 значащих цифр), поэтому double
        // даёт заметно более точное приближение 1/3.
    }
}

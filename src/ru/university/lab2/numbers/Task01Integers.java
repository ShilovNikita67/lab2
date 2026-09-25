package ru.university.lab2.numbers;

public class Task01Integers {
    public static void run(){
        printMinMaxIntegers();
        integerOverflow();
        multiplicationOverflow();
        divisionAndModulo();
        longToIntNarrowing();
        charArithmetic();
        overflowCheckDemo();

    }
    private static void printMinMaxIntegers(){
        System.out.println("byte"+Byte.MIN_VALUE+" "+Byte.MAX_VALUE);
        System.out.println("short"+Short.MIN_VALUE+" "+Short.MAX_VALUE);
        System.out.println("int"+Integer.MIN_VALUE+" "+Short.MAX_VALUE);
        System.out.println("long"+Long.MIN_VALUE+" "+Long.MAX_VALUE);
        // Диапазон типа определяется количеством бит под знаковое представление
        // (дополнительный код): byte - 8 бит, short - 16, int - 32, long - 64.

    }
    private static void integerOverflow(){
        int result = Integer.MAX_VALUE+1;
        System.out.println("Integer.MAX_VALUE+1="+result);
        // Переполнение int "молча" не сообщается: старший бит переходит в знаковый,
        // и MAX_VALUE (0111...1) + 1 даёт MIN_VALUE (1000...0) — переход по кругу.

    }
    private static void multiplicationOverflow(){
        int resultInt = Integer.MAX_VALUE*2;
        long resultLong =(long) Integer.MAX_VALUE*2;
        System.out.println("int_pr"+ resultInt);
        System.out.println("long_result"+ resultLong);
        // В int умножение выполняется в 32-битной арифметике и переполняется так же,
        // как и сложение (результат отрицательный из-за переноса в знаковый бит).
        // Приведение одного из операндов к long заставляет всё выражение
        // выполняться в 64-битной арифметике, где переполнения ещё не происходит.

    }
    private static void divisionAndModulo(){
        System.out.println(5/2);
        System.out.println(-5/2);
        System.out.println(5%2);
        System.out.println(-5%2);
        // Целочисленное деление в Java всегда округляет к нулю (а не вниз),
        // поэтому -5 / 2 = -2, а не -3. Знак результата % совпадает со знаком
        // делимого (левого операнда) — это следствие тождества:
        // a == (a / b) * b + (a % b).
    }
    private static void longToIntNarrowing(){
        long numLong = (long) Integer.MAX_VALUE+100;
        int numInt = (int) numLong;
        System.out.println("число Long: "+numLong);
        System.out.println("После приведения"+numInt);
        // При явном сужающем приведении отбрасываются старшие 32 бита
        // 64-битного представления, оставшиеся 32 бита интерпретируются
        // как обычное int-значение — отсюда "нелогичный" результат.
    }
    private static void charArithmetic(){
        char first = 'A';
        char next = (char) (first + 1);
        System.out.println("Первая буква: " +first);
        System.out.println("Следующая буква:" +next);
        int sumNumber = first + next;
        char SumCharNumber = (char) (first + next);
        System.out.println("Сумма как числа:"+ sumNumber);
        System.out.println("Сумма"+ SumCharNumber);
        // char в арифметических выражениях автоматически повышается до int
        // (это его числовой код в таблице Unicode), поэтому "letter + 1" — это
        // операция над числами; обратно в char нужно приводить явно.

    }
    private static boolean isOverflow(int a, int b){
        int sum = a+b;
        if (a>0 && b>0 && sum < 0){
            return true;
        }
        if (a<0 && b<0 && sum >= 0){
            return true;
        }
        return false;
        // Переполнение при сложении двух int происходит тогда и только тогда,
        // когда оба слагаемых одного знака, а результат — другого знака.
        // Разные знаки слагаемых переполнить сумму не могут: результат по модулю
        // не превышает большее по модулю слагаемое.
    }
    private static void overflowCheckDemo(){
        int a1 = Integer.MAX_VALUE;
        int b1 = 1;
        System.out.println("Пара с переполнением ("+ a1+"+"+b1+"):");
        System.out.println("Переполнение? "+isOverflow(a1,b1));
        System.out.println("Результат: "+(a1+b1));
        int a2 = 2000000000;
        int b2 = 100000000;
        System.out.println("Пара без переполнением ("+ a2+"+"+b2+"):");
        System.out.println("Переполенение? "+isOverflow(a2,b2));
        System.out.println("Результат: "+(a2+b2));
    }
}


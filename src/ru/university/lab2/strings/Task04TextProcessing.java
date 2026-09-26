package ru.university.lab2.strings;

public class Task04TextProcessing {
    public static void run() {
        palindromeDemo();
        reverseWordsDemo();
        countCharTypesDemo();
        caesarCipherDemo();
        longestWordDemo();
    }

    private static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            // Пропускаем всё, что не буква и не цифра
            while (left < right && !Character.isLetterOrDigit(chars[left])) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(chars[right])) {
                right--;
            }
            if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static void palindromeDemo() {
        System.out.println("=== 4.1 Проверка палиндрома ===");
        String[] samples = {"А роза упала на лапу Азора", "Java", "Madam, I'm Adam"};
        for (String s : samples) {
            System.out.println("\"" + s + "\" -> " + isPalindrome(s));
        }
    }

    private static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder();
        int end = chars.length; // конец текущего "хвоста", ещё не добавленного в результат
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                if (i + 1 < end) {
                    result.append(s, i + 1, end).append(' ');
                }
                end = i;
            }
        }
        if (end > 0) {
            result.append(s, 0, end);
        }
        return result.toString();
    }

    private static void reverseWordsDemo() {
        System.out.println("\n=== 4.2 Разворот порядка слов ===");
        String sentence = "кот съел мышь";
        System.out.println("\"" + sentence + "\" -> \"" + reverseWords(sentence) + "\"");
    }

    private static void countCharTypesDemo() {
        System.out.println("\n=== 4.3 Подсчёт типов символов за один проход ===");
        String text = "Hello, World! 123";
        String vowels = "aeiouAEIOU";
        int vowelCount = 0, consonantCount = 0, digitCount = 0, spaceCount = 0;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                if (vowels.indexOf(c) >= 0) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            } else if (Character.isDigit(c)) {
                digitCount++;
            } else if (c == ' ') {
                spaceCount++;
            }
        }
        System.out.println("text = \"" + text + "\"");
        System.out.println("гласные=" + vowelCount + " согласные=" + consonantCount
                + " цифры=" + digitCount + " пробелы=" + spaceCount);
    }

    private static String caesarEncrypt(String s, int k) {
        int shift = ((k % 26) + 26) % 26; // приводим сдвиг к диапазону [0, 25]
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'a' && c <= 'z') {
                chars[i] = (char) ('a' + (c - 'a' + shift) % 26);
            } else if (c >= 'A' && c <= 'Z') {
                chars[i] = (char) ('A' + (c - 'A' + shift) % 26);
            }
            // Прочие символы (пробелы, знаки препинания, не-латиница) не меняются.
        }
        return new String(chars);
    }

    private static String caesarDecrypt(String s, int k) {
        return caesarEncrypt(s, -k);
    }

    private static void caesarCipherDemo() {
        System.out.println("\n=== 4.4 Шифр Цезаря ===");
        String original = "Hello, World!";
        int shift = 3;
        String encrypted = caesarEncrypt(original, shift);
        String decrypted = caesarDecrypt(encrypted, shift);
        System.out.println("исходная:     " + original);
        System.out.println("зашифровано:  " + encrypted);
        System.out.println("расшифровано: " + decrypted);
    }

    private static String longestWord(String s) {
        String[] parts = s.split("\\s+");
        String longest = "";
        for (String part : parts) {
            if (part.length() > longest.length()) {
                longest = part;
            }
        }
        return longest;
    }

    private static void longestWordDemo() {
        System.out.println("\n=== 4.5 Самое длинное слово ===");
        String sentence = "маленький кот прыгнул на подоконник";
        System.out.println("\"" + sentence + "\" -> \"" + longestWord(sentence) + "\"");
    }
}

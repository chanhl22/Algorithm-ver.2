/**
 * playtime = 23:15
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Number1755 {
    int number;
    String english;

    public Number1755(int number, String english) {
        this.number = number;
        this.english = english;
    }
}

public class B1755 {
    private static int m;
    private static int n;
    private static final ArrayList<Number1755> numbers = new ArrayList<>();

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
    }

    private static void solution() {
        makeEnglish();
        numbers.sort(Comparator.comparing(o -> o.english));
        for (int i = 1; i <= numbers.size(); i++) {
            System.out.print(numbers.get(i - 1).number + " ");
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

    private static void makeEnglish() {
        for (int i = m; i <= n; i++) {
            int tenthDigit = i / 10;
            int firstDigit = i % 10;
            String tenthDigitString = change(tenthDigit);
            String firstDigitString = change(firstDigit);
            if (tenthDigitString.equals("zero")) {
                numbers.add(new Number1755(i, firstDigitString));
            } else {
                numbers.add(new Number1755(i, tenthDigitString + " " + firstDigitString));
            }
        }
    }

    private static String change(int number) {
        if (number == 1) {
            return "one";
        } else if (number == 2) {
            return "two";
        } else if (number == 3) {
            return "three";
        } else if (number == 4) {
            return "four";
        } else if (number == 5) {
            return "five";
        } else if (number == 6) {
            return "six";
        } else if (number == 7) {
            return "seven";
        } else if (number == 8) {
            return "eight";
        } else if (number == 9) {
            return "nine";
        } else {
            return "zero";
        }
    }
}

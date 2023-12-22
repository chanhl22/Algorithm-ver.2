/**
 * playtime = 01h 22m 23s
 */

import java.util.Arrays;
import java.util.Scanner;

public class B9440 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int[] numbers = input(sc);
            StringBuilder num1 = new StringBuilder();
            StringBuilder num2 = new StringBuilder();
            if (numbers.length % 2 == 0) {
                for (int i = 0; i < numbers.length; i += 2) {
                    num1.append(numbers[i]);
                    num2.append(numbers[i + 1]);
                }
            } else {
                num1.append(numbers[0]);
                for (int i = 1; i < numbers.length; i += 2) {
                    num1.append(numbers[i]);
                    num2.append(numbers[i + 1]);
                }
            }
            System.out.println(Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString()));
        }
    }

    private static int[] input(Scanner sc) {
        int count = sc.nextInt();
        if (count == 0) {
            System.exit(0);
        }
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);
        checkZero(numbers);
        return numbers;
    }

    private static void checkZero(int[] numbers) {
        int count = 0;
        for (int number : numbers) {
            if (number == 0) {
                count++;
            }
        }
        if (count == 0) {
            return;
        }

        int temp1 = numbers[count];
        int temp2 = numbers[count + 1];
        numbers[count] = 0;
        numbers[count + 1] = 0;
        numbers[0] = temp1;
        numbers[1] = temp2;
    }
}

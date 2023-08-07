/**
 * playtime = 01:42:17
 */

import java.util.Scanner;
import java.util.Stack;

public class B7490 {
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            solution();
            System.out.println();
        }
    }

    private static void solution() {
        Stack<String> stack = new Stack<>();
        stack.add("1");
        go(2, stack);
    }

    private static void go(int num, Stack<String> stack) {
        if (num > n) {
            if (calculate(stack) == 0) {
                for (String s : stack) {
                    System.out.print(s);
                }
                System.out.println();
            }
            return;
        }

        stack.add(" ");
        stack.add(String.valueOf(num));
        go(num + 1, stack);
        stack.pop();
        stack.pop();
        stack.add("+");
        stack.add(String.valueOf(num));
        go(num + 1, stack);
        stack.pop();
        stack.pop();
        stack.add("-");
        stack.add(String.valueOf(num));
        go(num + 1, stack);
        stack.pop();
        stack.pop();
    }

    private static int calculate(Stack<String> stack) {
        StringBuilder temp = new StringBuilder();
        for (String s : stack) {
            temp.append(s);
        }
        String replaceAll = temp.toString().replaceAll(" ", "");

        String[] numbers = replaceAll.split("[\\+\\-]");

        String replaceAll1 = replaceAll.replaceAll("[0-9]", "");
        String[] ops = replaceAll1.split("");

        int result = Integer.parseInt(numbers[0]);
        String tempOperator = "";
        for (int i = 1; i < numbers.length; i++) {
            tempOperator = ops[i - 1];
            int tempNumber = Integer.parseInt(numbers[i]);
            if ("+".equals(tempOperator)) {
                result += tempNumber;
            } else {
                result -= tempNumber;
            }
        }
        return result;
    }
}

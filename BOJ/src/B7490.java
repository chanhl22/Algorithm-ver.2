/**
 * playtime = 01:42:17
 */

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

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
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append(s);
        }

        StringTokenizer st = new StringTokenizer(sb.toString().replaceAll(" ", ""), "-+", true);
        int sum = Integer.parseInt(st.nextToken());
        while(st.hasMoreTokens()) {
            String op = st.nextToken();
            String number = st.nextToken();
            if ("+".equals(op)) {
                sum += Integer.parseInt(number);
            } else {
                sum -= Integer.parseInt(number);
            }
        }
        return sum;
    }
}

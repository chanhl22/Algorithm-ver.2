//playtime = 14:40

import java.util.Scanner;
import java.util.Stack;

public class B1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int input = 1;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!stack.isEmpty() && arr[index] == stack.peek()) {
                stack.pop();
                sb.append("-").append("\n");
                index++;
            } else {
                if (input > n) break;
                stack.push(input);
                sb.append("+").append("\n");
                input++;
            }
        }
        if (stack.isEmpty()) {
            System.out.print(sb.toString());
        } else {
            System.out.println("NO");
        }
    }
}

//playtime = 01:02:33

import java.util.Scanner;
import java.util.Stack;

public class B17298 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                a[stack.pop()] = a[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            a[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(a[i]).append(' ');
        }
        System.out.println(sb);
    }
}

//playtime = 07:53

import java.util.Scanner;
import java.util.Stack;

public class B2841 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        Stack<Integer>[] stack = new Stack[n + 1];
        for (int i = 1; i <= n; i++) {
            stack[i] = new Stack<>();
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int line = sc.nextInt();
            int pratt = sc.nextInt();
            while (!stack[line].isEmpty() && pratt < stack[line].peek()) {
                stack[line].pop();
                cnt++;
            }
            if (!stack[line].isEmpty() && pratt == stack[line].peek()) continue;
            stack[line].push(pratt);
            cnt++;
        }
        System.out.println(cnt);
    }
}
/**
 * playtime = 01:15:55
 */

import java.util.Scanner;
import java.util.Stack;

public class B6198 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long result = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            while (!s.isEmpty() && s.peek() <= temp) {
                s.pop();
            }
            s.push(temp);
            result += s.size() - 1;
        }

        System.out.println(result);
    }
}
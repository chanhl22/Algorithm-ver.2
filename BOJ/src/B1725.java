/**
 * playtime = 01:39:34
 * 못풀었음
 */

import java.util.Scanner;
import java.util.Stack;

public class B1725 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long min = -1;

        Stack<Long> stack = new Stack<>();
        long area = 0;
        long before = 0;
        for (int i = 0; i < n; i++) {
            long input = sc.nextLong();
            if (min == -1 || min > input) {
                min = input;
            }
            if (before > input) {
                stack.clear();
            }
            stack.add(input);
            before = input;

            for (int j = 0; j < stack.size(); j++) {
                long tempArea = stack.get(j) * (stack.size() - j);
                if (area < tempArea) {
                    area = tempArea;
                }
            }
        }

        if (min * n > area) {
            area = min * n;
        }

        System.out.println(area);
    }
}

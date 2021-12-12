//playtime = 11:58

import java.util.Scanner;
import java.util.Stack;

public class B10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            int temp = sc.nextInt();
            if (temp == 0) {
                stack.pop();
            } else {
                stack.push(temp);
            }
        }
        long sum = 0;
        for (int num : stack) {
            sum += num;
        }
        System.out.println(sum);
    }
}

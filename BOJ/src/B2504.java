//playtime = 51:41

import java.util.Scanner;
import java.util.Stack;

public class B2504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String str = sc.nextLine();
        int ans = 0;
        int temp = 1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(ch);
                temp *= 2;
            } else if (ch == '[') {
                stack.push(ch);
                temp *= 3;
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    ans = 0;
                    break;
                }
                if (str.charAt(i - 1) == '(') {
                    ans += temp;
                }
                stack.pop();
                temp /= 2;
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    ans = 0;
                    break;
                }
                if (str.charAt(i - 1) == '[') {
                    ans += temp;
                }
                stack.pop();
                temp /= 3;
            }
        }
        System.out.println(stack.isEmpty() ? ans : 0);
    }
}
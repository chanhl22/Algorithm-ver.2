//playtime = 44:37

import java.util.Scanner;
import java.util.Stack;

public class B10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Character temp = s.charAt(i);
            if (temp == '(') {
                stack.push(temp);
            } else if (temp == ')') {
                stack.pop();
                if (s.charAt(i - 1) == '(') {
                    ans += stack.size();
                } else {
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }
}

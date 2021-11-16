//playtime = 37:27

import java.util.Scanner;
import java.util.Stack;

public class B3986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int cnt = 0;
        while (t-- > 0) {
            String str = sc.next();
            int n = str.length();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                if (!stack.empty() && stack.peek() == str.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(str.charAt(i));
                }
            }
            if (stack.isEmpty()) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

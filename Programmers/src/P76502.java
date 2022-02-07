//playtime = 32:10

import java.util.*;

class Solution93 {
    static Queue<Character> q;
    static int n;

    public int solution(String s) {
        int answer = 0;
        n = s.length();
        q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            q.add(q.remove());
            if (check()) {
                answer++;
            }
        }
        return answer;
    }

    private boolean check() {
        Stack<Character> stack = new Stack<>();
        System.out.println(q.size());
        for (int i = 0; i < n; i++) {
            char temp = q.remove();
            if (!stack.isEmpty() && stack.peek() == '[' && temp == ']') {
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek() == '(' && temp == ')') {
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek() == '{' && temp == '}') {
                stack.pop();
            } else {
                stack.push(temp);
            }
            q.add(temp);
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

public class P76502 {
    public static void main(String[] args) {
        Solution93 sol = new Solution93();
        int ans = 0;
        ans = sol.solution("[](){}");
        System.out.println(ans);
    }
}
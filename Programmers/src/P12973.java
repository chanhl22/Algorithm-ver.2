//playtime = 04:54

import java.util.Stack;

class Solution90 {
    public int solution(String s) {
        int answer = -1;
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return answer = stack.isEmpty() ? 1 : 0;
    }
}


public class P12973 {
    public static void main(String[] args) {
        Solution90 sol = new Solution90();
        int ans = 0;
        ans = sol.solution("baabaa");
        ans = sol.solution("cdcd");
        System.out.println(ans);
    }
}
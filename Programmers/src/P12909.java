/**
 * playtime = 7m 32s
 */

import java.util.Stack;

public class P12909 {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        boolean ans = sol.solution("()()");
//        boolean ans = sol.solution("(())()");
//        boolean ans = sol.solution(")()(");
        boolean ans = sol.solution("(()(");
        System.out.println(ans);
    }

    static class Solution {
        public boolean solution(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push('(');
                } else if (s.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        return false;
                    }

                    if (stack.peek() != '(') {
                        return false;
                    }

                    stack.pop();
                }
            }

            return stack.isEmpty();
        }
    }
}
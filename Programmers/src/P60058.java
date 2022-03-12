//playtime = 50:11

import java.util.Stack;

class Solution103 {
    public String solution(String p) {
        if (isCorrect(p)) {
            return p;
        }
        String answer = "";
        if (p.equals("")) {
            return "";
        }
        int len = p.length();
        String u = "";
        String v = "";
        for (int i = 0; i < len; i++) {
            u += p.charAt(i);
            if (isBalance(u)) {
                v = p.substring(i + 1);
                break;
            }
        }
        if (isCorrect(u)) {
            answer = u + solution(v);
        } else {
            answer += "(" + solution(v) + ")";
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') {
                    answer += ")";
                } else {
                    answer += "(";
                }
            }
        }
        return answer;
    }

    private boolean isCorrect(String p) {
        Stack<Character> stack = new Stack<>();
        int len = p.length();
        for (int i = 0; i < len; i++) {
            if (p.charAt(i) == '(') {
                stack.push(p.charAt(i));
            } else {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isBalance(String p) {
        int countLeft = 0;
        int countRight = 0;
        int len = p.length();
        for (int i = 0; i < len; i++) {
            if (p.charAt(i) == '(') {
                countRight++;
            } else {
                countLeft++;
            }
        }
        if (countLeft == countRight) {
            return true;
        } else {
            return false;
        }
    }
}

public class P60058 {
    public static void main(String[] args) {
        Solution103 sol = new Solution103();
        String ans = sol.solution("(()())()");
//        String ans = sol.solution(")(");
//        String ans = sol.solution("()))((()");
        System.out.println(ans);
    }
}
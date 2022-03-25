package question;

import java.util.Stack;

class Solution68 {
    public int solution(String s) {
        char remove_bracket = check_bracket(s);
        int answer = insert_bracket(remove_bracket, s);
        return answer;
    }

    private int insert_bracket(char remove_bracket, String s) {
        int count = 0;
        int n = s.length();
        if (remove_bracket == '(' || remove_bracket == '[' || remove_bracket == '{') {
            for (int i = 0; i < n; i++) {
                String temp = "";
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        temp += remove_bracket;
                    }
                    temp += s.charAt(j);
                }
                if (correct_bracket(temp)) {
                    count++;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                String temp = "";
                for (int j = 0; j < n; j++) {
                    temp += s.charAt(j);
                    if (i == j) {
                        temp += remove_bracket;
                    }
                }
                if (correct_bracket(temp)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean correct_bracket(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty() && stack.peek() == '(' && s.charAt(i) == ')') {
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek() == '{' && s.charAt(i) == '}') {
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek() == '[' && s.charAt(i) == ']') {
                stack.pop();
            } else {
                stack.add(s.charAt(i));
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private char check_bracket(String s) {
        int n = s.length();
        int a = 0; // (
        int b = 0; // )
        int c = 0; // [
        int d = 0; // ]
        int e = 0; // {
        int f = 0; // }
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                a++;
            } else if (s.charAt(i) == ')') {
                b++;
            } else if (s.charAt(i) == '[') {
                c++;
            } else if (s.charAt(i) == ']') {
                d++;
            } else if (s.charAt(i) == '{') {
                e++;
            } else if (s.charAt(i) == '}') {
                f++;
            }
        }
        if (a != b) {
            if (a > b) {
                return ')';
            } else {
                return '(';
            }
        } else if (c != d) {
            if (c > d) {
                return ']';
            } else {
                return '[';
            }
        } else {
            if (e > f) {
                return '}';
            } else {
                return '{';
            }
        }
    }
}


public class So1_1 {
    public static void main(String[] args) {
        Solution68 sol = new Solution68();
        int ans = 0;
//        ans = sol.solution("[]([[]){}"); //3
//        ans = sol.solution("{([()]))}"); //4
//        ans = sol.solution("(()()()"); //7
//        ans = sol.solution("[]([{{}}[]){}"); //4
//        ans = sol.solution("[]([[][]){}"); //5
//        ans = sol.solution("(()()"); //5
//        ans = sol.solution("()({}{{}}{}{}{}{}{}()"); //10
//        ans = sol.solution("("); //1
//        ans = sol.solution(")"); //1
//        ans = sol.solution("()())()"); //5
        ans = sol.solution("([{}]()[{}]()))"); //9
        System.out.println(ans);
    }
}
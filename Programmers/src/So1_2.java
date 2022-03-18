import java.util.Stack;

class Solution107 {
    public int solution(String s) {
        int count = 0;
        char remove_bracket = check_bracket(s);
        char reverse_bracket = reverse(remove_bracket);
        int index = 0;
        int n = s.length();
        if (remove_bracket == '(' || remove_bracket == '[' || remove_bracket == '{') {
            index = correct_right(s);
            for (int i = 0; i <= index; i++) {
                if (s.charAt(i) == remove_bracket || s.charAt(i) == reverse_bracket) {
                    count++;
                } else if (s.charAt(i) != remove_bracket) {
                    char temp = s.charAt(i);
                    char reverse_temp = reverse(temp);
                    int temp_cnt = 1;
                    i++;
                    while (true) {
                        if (s.charAt(i) == temp) {
                            temp_cnt++;
                        }
                        if (s.charAt(i) == reverse_temp) {
                            temp_cnt--;
                        }
                        if (s.charAt(i) == reverse_temp && temp_cnt == 0) {
                            break;
                        }
                        i++;
                    }
                    count++;
                }
            }
        } else {
            index = correct_left(s);
            for (int i = index; i < n; i++) {
                if (s.charAt(i) == remove_bracket || s.charAt(i) == reverse_bracket) {
                    count++;
                } else if (s.charAt(i) != remove_bracket) {
                    char temp = s.charAt(i);
                    char reverse_temp = reverse(temp);
                    int temp_cnt = 1;
                    i++;
                    while (true) {
                        if (s.charAt(i) == temp) {
                            temp_cnt++;
                        }
                        if (s.charAt(i) == reverse_temp) {
                            temp_cnt--;
                        }
                        if (s.charAt(i) == reverse_temp && temp_cnt == 0) {
                            break;
                        }
                        i++;
                    }
                    count++;
                }
            }
        }
        return count;
    }

    private char reverse(char bracket) {
        if (bracket == '(') {
            return ')';
        } else if (bracket == '{') {
            return '}';
        } else if (bracket == '[') {
            return ']';
        } else if (bracket == ')') {
            return '(';
        } else if (bracket == '}') {
            return '{';
        } else {
            return '[';
        }
    }

    private int correct_left(String s) {
        int n = s.length();
        int index = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (!stack.isEmpty() && stack.peek() == ')' && s.charAt(i) == '(') {
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek() == '}' && s.charAt(i) == '{') {
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek() == ']' && s.charAt(i) == '[') {
                stack.pop();
            } else {
                if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                    index = i;
                }
                stack.add(s.charAt(i));
            }
        }
        return index;
    }

    private int correct_right(String s) {
        int n = s.length();
        int index = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty() && stack.peek() == '(' && s.charAt(i) == ')') {
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek() == '{' && s.charAt(i) == '}') {
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek() == '[' && s.charAt(i) == ']') {
                stack.pop();
            } else {
                if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                    index = i;
                }
                stack.add(s.charAt(i));
            }
        }
        return index;
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


public class So1_2 {
    public static void main(String[] args) {
        Solution107 sol = new Solution107();
        int ans = 0;
        ans = sol.solution("[]([[]){}"); //3
//        ans = sol.solution("{([()]))}"); //4
//        ans = sol.solution("(()()()"); //7
//        ans = sol.solution("[]([{{}}[]){}"); //4
//        ans = sol.solution("[]([[][]){}"); //5
//        ans = sol.solution("(()()"); //5
//        ans = sol.solution("()({}{{}}{}{}{}{}{}()"); //10
//        ans = sol.solution("("); //1
//        ans = sol.solution(")"); //1
//        ans = sol.solution("()())()"); //5
//        ans = sol.solution("([{}]()[{}]()))"); //9
        System.out.println(ans);
    }
}
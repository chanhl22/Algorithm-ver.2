package question;

class Solution107 {
    static int n;
    static int[][] sum;

    public int solution(String s) {
        n = s.length();
        char remove_bracket = check_bracket(s);
        sum = new int[3][n];
        if (remove_bracket == ')' || remove_bracket == ']' || remove_bracket == '}') {
            init_1(s);
        } else {
            init_2(s);
        }
        int first_index = first_index_check(remove_bracket);
        int count = find_position(remove_bracket, first_index);
        return count;
    }

    private void init_2(String s) {
        if (s.charAt(n - 1) == '(') {
            sum[0][n - 1] = -1;
        } else if (s.charAt(n - 1) == '[') {
            sum[1][n - 1] = -1;
        } else if (s.charAt(n - 1) == '{') {
            sum[2][n - 1] = -1;
        } else if (s.charAt(n - 1) == ')') {
            sum[0][n - 1] = 1;
        } else if (s.charAt(n - 1) == ']') {
            sum[1][n - 1] = 1;
        } else if (s.charAt(n - 1) == '}') {
            sum[2][n - 1] = 1;
        }
        for (int j = n - 2; j >= 0; j--) {
            if (s.charAt(j) == '(') {
                sum[0][j] = sum[0][j + 1] - 1;
            } else if (s.charAt(j) == ')') {
                sum[0][j] = sum[0][j + 1] + 1;
            } else {
                sum[0][j] = sum[0][j + 1];
            }
        }
        for (int j = n - 2; j >= 0; j--) {
            if (s.charAt(j) == '[') {
                sum[1][j] = sum[1][j + 1] - 1;
            } else if (s.charAt(j) == ']') {
                sum[1][j] = sum[1][j + 1] + 1;
            } else {
                sum[1][j] = sum[1][j + 1];
            }
        }
        for (int j = n - 2; j >= 0; j--) {
            if (s.charAt(j) == '{') {
                sum[2][j] = sum[2][j + 1] - 1;
            } else if (s.charAt(j) == '}') {
                sum[2][j] = sum[2][j + 1] + 1;
            } else {
                sum[2][j] = sum[2][j + 1];
            }
        }
    }

    private int find_position(char remove_bracket, int first_index) {
        int count = 0;
        int a = sum[0][first_index];
        int b = sum[1][first_index];
        int c = sum[2][first_index];
        if (remove_bracket == ')' || remove_bracket == ']' || remove_bracket == '}') {
            if (remove_bracket == ')') {
                for (int i = first_index; i < n; i++) {
                    if (sum[1][i] == b && sum[2][i] == c) {
                        count++;
                    }
                }
            }
            if (remove_bracket == ']') {
                for (int i = first_index; i < n; i++) {
                    if (sum[0][i] == a && sum[2][i] == c) {
                        count++;
                    }
                }
            }
            if (remove_bracket == '}') {
                for (int i = first_index; i < n; i++) {
                    if (sum[0][i] == a && sum[1][i] == b) {
                        count++;
                    }
                }
            }
        } else {
            if (remove_bracket == '(') {
                for (int i = first_index; i >= 0; i--) {
                    if (sum[1][i] == b && sum[2][i] == c) {
                        count++;
                    }
                }
            }
            if (remove_bracket == '[') {
                for (int i = first_index; i >= 0; i--) {
                    if (sum[0][i] == a && sum[2][i] == c) {
                        count++;
                    }
                }
            }
            if (remove_bracket == '{') {
                for (int i = first_index; i >= 0; i--) {
                    if (sum[0][i] == a && sum[1][i] == b) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private int first_index_check(char remove_bracket) {
        int index = 0;
        if (remove_bracket == ')' || remove_bracket == ']' || remove_bracket == '}') {
            index = 0;
        } else {
            index = n - 1;
        }
        boolean ok = true;
        if (remove_bracket == '(' || remove_bracket == ')') {
            for (int i = 0; i < n; i++) {
                if (sum[0][i] == 0) {
                    ok = false;
                    index = i;
                }
            }
        }
        if (remove_bracket == '[' || remove_bracket == ']') {
            for (int i = 0; i < n; i++) {
                if (sum[1][i] == 0) {
                    ok = false;
                    index = i;
                }
            }
        }
        if (remove_bracket == '{' || remove_bracket == '}') {
            for (int i = 0; i < n; i++) {
                if (sum[0][i] == 0) {
                    ok = false;
                    index = i;
                }
            }
        }
        if (remove_bracket == ')' || remove_bracket == ']' || remove_bracket == '}') {
            if (ok == true) {
                return index;
            }
            return index + 1;
        } else {
            if (ok == true) {
                return index;
            }
            return index - 1;
        }
    }

    private void init_1(String s) {
        if (s.charAt(0) == '(') {
            sum[0][0] = 1;
        } else if (s.charAt(0) == '[') {
            sum[1][0] = 1;
        } else if (s.charAt(0) == '{') {
            sum[2][0] = 1;
        } else if (s.charAt(0) == ')') {
            sum[0][0] = -1;
        } else if (s.charAt(0) == ']') {
            sum[1][0] = -1;
        } else if (s.charAt(0) == '}') {
            sum[2][0] = -1;
        }
        for (int j = 1; j < n; j++) {
            if (s.charAt(j) == '(') {
                sum[0][j] = sum[0][j - 1] + 1;
            } else if (s.charAt(j) == ')') {
                sum[0][j] = sum[0][j - 1] - 1;
            } else {
                sum[0][j] = sum[0][j - 1];
            }
        }
        for (int j = 1; j < n; j++) {
            if (s.charAt(j) == '[') {
                sum[1][j] = sum[1][j - 1] + 1;
            } else if (s.charAt(j) == ']') {
                sum[1][j] = sum[1][j - 1] - 1;
            } else {
                sum[1][j] = sum[1][j - 1];
            }
        }
        for (int j = 1; j < n; j++) {
            if (s.charAt(j) == '{') {
                sum[2][j] = sum[2][j - 1] + 1;
            } else if (s.charAt(j) == '}') {
                sum[2][j] = sum[2][j - 1] - 1;
            } else {
                sum[2][j] = sum[2][j - 1];
            }
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


public class So1_2 {
    public static void main(String[] args) {
        Solution107 sol = new Solution107();
        int ans = 0;
//        ans = sol.solution("[]([[]){}"); //3
        ans = sol.solution("{([()]))}"); //4
//        ans = sol.solution("(()()()"); //7
//        ans = sol.solution("[]([{{}}[]){}"); //4
//        ans = sol.solution("[]([[][]){}"); //5
//        ans = sol.solution("(()()"); //5
//        ans = sol.solution("()({}{{}}{}{}{}{}{}()"); //10
//        ans = sol.solution("("); //1
//        ans = sol.solution(")"); //1
//        ans = sol.solution("()())()"); //5
//        ans = sol.solution("([{}]()[{}]()))"); //9
        ans = sol.solution("{}()[())]()"); //3
        System.out.println(ans);
    }
}
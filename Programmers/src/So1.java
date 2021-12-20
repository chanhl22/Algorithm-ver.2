import java.util.Stack;

class Solution68 {
    public int solution(String s) {
        int answer = 0;

        boolean check = check_rev(s);

        if (!check) {
            s = reverse_string(s);
        }

        int[] index = index_check(s);
        int first = index[0];
        int last = index[1];

        String str = s.substring(first, last);
        if (str.equals("")) {
            return 1;
        }
        if (str.charAt(0) == '(') {
            answer = count_string(str, '(', ')');
        } else if (str.charAt(0) == '[') {
            answer = count_string(str, '[', ']');
        } else if (str.charAt(0) == '{') {
            answer = count_string(str, '{', '}');
        }
        return answer;
    }

    private int[] index_check(String s) {
        int[] ret = new int[2];
        Stack<Character> stack = new Stack<>();
        int first = 0; //처음 인덱스
        int last = s.length(); //마지막 인덱스
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            size++;
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                    if (stack.isEmpty()) {
                        size = 0;
                    }
                } else {
                    size -= 2;
                    last = i;
                    break;
                }
            } else if (ch == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                    if (stack.isEmpty()) {
                        size = 0;
                    }
                } else {
                    size -= 2;
                    last = i;
                    break;
                }
            } else if (ch == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                    if (stack.isEmpty()) {
                        size = 0;
                    }
                } else {
                    size -= 2;
                    last = i;
                    break;
                }
            }
        }
        first = last - size;
        ret[0] = first;
        ret[1] = last;
        return ret;
    }

    private boolean check_rev(String s) {
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                cnt1++;
            } else if (ch == ')' || ch == ']' || ch == '}') {
                cnt2++;
            }
        }
        //check = true -> )]}가 없음
        //check = false -> ([{가 없음
        boolean check = false;
        if (cnt1 > cnt2) {
            check = true;
        }
        return check;
    }

    private String reverse_string(String s) {
        String ret = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                ret = "}" + ret;
            } else if (s.charAt(i) == '}') {
                ret = "{" + ret;
            } else if (s.charAt(i) == '(') {
                ret = ")" + ret;
            } else if (s.charAt(i) == ')') {
                ret = "(" + ret;
            } else if (s.charAt(i) == '[') {
                ret = "]" + ret;
            } else if (s.charAt(i) == ']') {
                ret = "[" + ret;
            }
        }
        return ret;
    }

    private int count_string(String str, char s1, char s2) {
        int ret = 0;
        int count = 0;
        boolean ok = false;
        for (int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i);
            if (ch == '(') {
                if (str.charAt(0) == '(') {
                    ret++;
                    continue;
                }
                count++;
                while (true) {
                    i++;
                    ok = true;
                    if (str.charAt(i) == ')') {
                        break;
                    }
                }
            } else if (ch == '[') {
                if (str.charAt(0) == '[') {
                    ret++;
                    continue;
                }
                count++;
                while (true) {
                    i++;
                    ok = true;
                    if (str.charAt(i) == ']') {
                        break;
                    }
                }
            } else if (ch == '{') {
                if (str.charAt(0) == '{') {
                    ret++;
                    continue;
                }
                count++;
                while (true) {
                    i++;
                    ok = true;
                    if (str.charAt(i) == '}') {
                        break;
                    }
                }
            }
        }
        if (count != 0) {
            return (ret * 2) - 1 + count;
        }
        return (ok ? ret * 2 + count : (ret * 2) - 1 + count);
    }
}


public class So1 {
    public static void main(String[] args) {
        Solution68 sol = new Solution68();
        int ans = 0;
//        ans = sol.solution("[]([[]){}");
//        ans = sol.solution("{([()]))}");
//        ans = sol.solution("(()()()");
//        ans = sol.solution("[]([{{}}[]){}");
//        ans = sol.solution("[]([[][]){}");
//        ans = sol.solution("(()()");
//        ans = sol.solution("()({}{{}}{}{}{}{}{}()");
        ans = sol.solution("({(})");
        System.out.println(ans);
    }
}
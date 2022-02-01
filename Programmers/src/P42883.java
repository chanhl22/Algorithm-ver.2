//playtime = 46:07

import java.util.Stack;

class Solution86 {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Integer> stack = new Stack<>();
        int n = number.length();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() < number.charAt(i) - '0') {
                if (k == 0) break;
                if (k > 0) {
                    stack.pop();
                    k--;
                }
            }
            stack.push(number.charAt(i) - '0');
        }
        while (k != 0) {
            stack.pop();
            k--;
        }
        for (int num : stack) {
            answer = answer + num;
        }
        return answer;
    }
}

//Add Solution
//class Solution {
//    public String solution(String number, int k) {
//        char[] result = new char[number.length() - k];
//        Stack<Character> stack = new Stack<>();
//
//        for (int i=0; i<number.length(); i++) {
//            char c = number.charAt(i);
//            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
//                stack.pop();
//            }
//            stack.push(c);
//        }
//        for (int i=0; i<result.length; i++) {
//            result[i] = stack.get(i);
//        }
//        return new String(result);
//    }
//}

public class P42883 {
    public static void main(String[] args) {
        Solution86 sol = new Solution86();
//        String ans = sol.solution("1924", 2);
//        String ans = sol.solution("1231234", 3);
//        String ans = sol.solution("4177252841", 4);
        String ans = sol.solution("7654", 1);
        System.out.println(ans);
    }
}
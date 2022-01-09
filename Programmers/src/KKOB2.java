import java.util.ArrayList;
import java.util.Stack;

class Solution75 {
    public long solution(String[] arr1, String[] arr2) {
        long answer = 0;
        int check_arr1 = 0;
        int check_arr2 = 0;
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            int tmp = check(arr1[i]);
            if (tmp == 1) {
                check_arr1 += tmp;
            } else {
                if (arr1[i].charAt(0) == ')') {
                    continue;
                }
                list1.add(arr1[i]);
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            int tmp = check(arr2[i]);
            if (tmp == 1) {
                check_arr2 += tmp;
            } else {
                list2.add(arr2[i]);
            }
        }
        answer += check_arr1 * check_arr2;

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                String s = list1.get(i) + list2.get(j);
                answer += check(s);
            }
        }
        return answer;
    }

    private int check(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return 0;
                }
            }
        }
        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }
}


public class KKOB2 {
    public static void main(String[] args) {
        Solution75 sol = new Solution75();
        long ans = 0;
//        ans = sol.solution(new String[]{"()", "(()", ")()", "()"}, new String[]{")()", "()", "(()"});
        ans = sol.solution(new String[]{"()", "(()", "(", "(())"}, new String[]{")()","()", "(())", ")()"});
        System.out.println(ans);
    }
}
/**
 * 뒤에 있는 큰 수 찾기
 * playtime = 48m 10s
 * 풀이횟수 = 2
 */

import java.util.Arrays;
import java.util.Stack;

public class P154539 {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[] ans = sol.solution(new int[]{2, 3, 3, 5});
        int[] ans = sol.solution(new int[]{9, 1, 5, 3, 6, 2});
        System.out.println(Arrays.toString(ans));
    }

    static class Solution {
        public int[] solution(int[] numbers) {
            int len = numbers.length;
            Stack<Integer> stack = new Stack<>();
            int[] answer = new int[len];
            Arrays.fill(answer, -1);

            for (int curIndex = 0; curIndex < len; curIndex++) {
                if (curIndex == 0) {
                    stack.push(curIndex);
                    continue;
                }

                if (numbers[curIndex - 1] < numbers[curIndex]) {
                    while (!stack.isEmpty() && numbers[stack.peek()] < numbers[curIndex]) {
                        Integer beforeIndex = stack.pop();
                        answer[beforeIndex] = numbers[curIndex];
                    }
                }

                stack.push(curIndex);
            }

            return answer;
        }
    }
}

//import java.util.Arrays;
//import java.util.Stack;
//
//class Solution154539 {
//    public int[] solution(int[] numbers) {
//        Stack<Integer> stack = new Stack<>();
//        int[] answer = new int[numbers.length];
//        Arrays.fill(answer, -1);
//
//        for (int cur = 0; cur < numbers.length; cur++) {
//            if (cur == 0) {
//                stack.push(cur);
//                continue;
//            }
//
//            if (numbers[cur - 1] < numbers[cur]) {
//                while (!stack.isEmpty() && numbers[stack.peek()] < numbers[cur]) {
//                    answer[stack.pop()] = numbers[cur];
//                }
//            }
//            stack.push(cur);
//        }
//
//        return answer;
//    }
//}
//
//public class P154539 {
//    public static void main(String[] args) {
//        Solution154539 sol = new Solution154539();
//        int[] ans = sol.solution(new int[]{2, 3, 3, 5});
/// /        int[] ans = sol.solution(new int[]{9, 1, 5, 3, 6, 2});
//        System.out.println(Arrays.toString(ans));
//    }
//}
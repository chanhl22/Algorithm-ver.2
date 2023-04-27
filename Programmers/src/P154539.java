/**
 * playtime = 01:40:35
 */

import java.util.Arrays;
import java.util.Stack;

class Solution154539 {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        for (int cur = 0; cur < numbers.length; cur++) {
            if (cur == 0) {
                stack.push(cur);
                continue;
            }

            if (numbers[cur - 1] < numbers[cur]) {
                while (!stack.isEmpty() && numbers[stack.peek()] < numbers[cur]) {
                    answer[stack.pop()] = numbers[cur];
                }
            }
            stack.push(cur);
        }

        return answer;
    }
}

public class P154539 {
    public static void main(String[] args) {
        Solution154539 sol = new Solution154539();
        int[] ans = sol.solution(new int[]{2, 3, 3, 5});
//        int[] ans = sol.solution(new int[]{9, 1, 5, 3, 6, 2});
        System.out.println(Arrays.toString(ans));
    }
}
/**
 * playtime = 01:18:36
 */

import java.util.Arrays;

class Solution178870 {
    public int[] solution(int[] sequence, int k) {
        int startIndex = 0;
        int endIndex = 0;
        int sum = 0;
        int answerStart = 0;
        int answerEnd = 0;
        int scope = Integer.MAX_VALUE;
        while (endIndex < sequence.length) {
            sum += sequence[endIndex];
            if (sum < k) {
                endIndex++;
                continue;
            }
            if (sum == k) {
                if (scope > endIndex - startIndex) {
                    scope = endIndex - startIndex;
                    answerStart = startIndex;
                    answerEnd = endIndex;
                }
            }
            sum -= sequence[startIndex];
            sum -= sequence[endIndex];
            startIndex++;
        }

        return new int[]{answerStart, answerEnd};
    }
}

public class P178870 {
    public static void main(String[] args) {
        Solution178870 sol = new Solution178870();
        int[] ans = sol.solution(new int[]{1, 2, 3, 4, 5}, 7);
//        int[] ans = sol.solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5);
        System.out.println(Arrays.toString(ans));
    }
}

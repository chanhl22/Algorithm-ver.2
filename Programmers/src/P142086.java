/**
 * playtime = 10m 24s
 */

import java.util.Arrays;

public class P142086 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] ans = sol.solution("banana");
        System.out.println(Arrays.toString(ans));
    }

    static class Solution {
        public int[] solution(String s) {
            int[] answer = new int[s.length()];
            int[] alphaIndex = new int[26];
            Arrays.fill(alphaIndex, -1);

            for (int i = 0; i < s.length(); i++) {
                int index = alphaIndex[s.charAt(i) - 'a'];
                if (index == -1) {
                    answer[i] = -1;
                } else {
                    answer[i] = i - index;
                }
                alphaIndex[s.charAt(i) - 'a'] = i;
            }

            return answer;
        }
    }
}
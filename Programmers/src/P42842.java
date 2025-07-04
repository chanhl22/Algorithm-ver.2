/**
 * 카펫
 * playtime = 16m 18s
 */

import java.util.Arrays;

public class P42842 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        //int[] ans = sol.solution(10, 2);
        //int[] ans = sol.solution(8, 1);
        int[] ans = sol.solution(24, 24);
        System.out.println(Arrays.toString(ans));
    }

    static class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            for (int i = 1; i <= yellow; i++) {
                if (yellow % i == 0) {
                    int row = i;
                    int col = yellow / i;
                    if (row >= col && brown == row * 2 + col * 2 + 4) {
                        answer[0] = row + 2;
                        answer[1] = col + 2;
                    }
                }
            }
            return answer;
        }
    }

}
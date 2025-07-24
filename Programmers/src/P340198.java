/**
 * [PCCE 기출문제] 10번 / 공원
 * playtime = 13m 17s
 */

import java.util.Arrays;

public class P340198 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] mats = {5, 3, 2};
        String[][] park = {
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        };

        int ans = 0;
        ans = sol.solution(mats, park);
        System.out.println(ans);
    }

    static class Solution {
        public int solution(int[] mats, String[][] park) {
            int answer = -1;

            Arrays.sort(mats);
            int n = park.length;
            int m = park[0].length;

            for (int matIndex = 0; matIndex < mats.length; matIndex++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (check(i, j, park, mats[matIndex])) {
                            answer = mats[matIndex];
                        }
                    }
                }
            }

            return answer;
        }

        private boolean check(int x, int y, String[][] park, int mat) {
            if (!park[x][y].equals("-1")) {
                return false;
            }

            for (int i = x; i < x + mat; i++) {
                for (int j = y; j < y + mat; j++) {
                    if (i >= park.length || j >= park[0].length) {
                        return false;
                    }
                    if (!park[i][j].equals("-1")) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
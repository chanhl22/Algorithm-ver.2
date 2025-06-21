/**
 * 등굣길
 * playtime = 42m 22s
 */

public class P42898 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
//        ans = sol.solution(4, 3, new int[][]{{2, 2}});
        ans = sol.solution(100, 100, new int[][]{{2, 2}});
        System.out.println(ans);
    }

    static class Solution {

        private final static int MOD = 1000000007;

        public int solution(int m, int n, int[][] puddles) {
            int[][] dp = new int[n + 1][m + 1];

            updatePool(puddles, dp);

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (dp[i][j] == -1) {
                        continue;
                    }

                    if (i == 1 && j == 1) {
                        dp[i][j] = 1;
                        continue;
                    }

                    if (dp[i - 1][j] == -1 &&  dp[i][j - 1] == -1) {
                        dp[i][j] = 0;
                    } else if (dp[i - 1][j] == -1) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (dp[i][j - 1] == -1) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = ((dp[i - 1][j] % MOD) + (dp[i][j - 1] % MOD)) % MOD;
                    }
                }
            }

            return dp[n][m];
        }

        private void updatePool(int[][] puddles, int[][] map) {
            for (int i = 0; i < puddles.length; i++) {
                map[puddles[i][1]][puddles[i][0]] = -1;
            }
        }
    }
}
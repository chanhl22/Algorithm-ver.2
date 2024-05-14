package question.superblock;

import java.util.Arrays;

public class Superblock2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
        ans = sol.solution(9, 3);
        System.out.println(ans);
    }

    static class Solution {

        private static final int MOD = 1000000007;
        private static int[][] dp;

        public int solution(int n, int k) {
            dp = new int[n + 1][k + 1];

            // 기본 조건
            dp[0][0] = 1; // 0번 점프로 0에 도달하는 방법은 1가지

            // dp 테이블 채우기
            for (int jump = 1; jump <= k; jump++) {
                for (int pos = 1; pos <= n; pos++) {
                    for (int prevJump = jump - 1; prevJump <= pos; prevJump++) {
                        dp[pos][jump] = (dp[pos][jump] + dp[pos - prevJump][jump - 1]) % MOD;
                    }
                }
            }

            return dp[n][k];
        }
    }
}
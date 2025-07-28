/**
 * 멀리 뛰기
 * playtime = 06m 10s
 */

public class P12914 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        long ans = 0;
        ans = sol.solution(4);
        System.out.println(ans);
    }

    static class Solution {

        private static long MOD = 1234567L;

        public long solution(int n) {
            long[] dp = new long[2001];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 1] % MOD + dp[i - 2] % MOD) % MOD;
            }

            return dp[n] % MOD;
        }
    }
}
/**
 * playtime = 1h 32m 26s
 */

/**
 * dp[i] = 거스름돈 i원 을 만드는 경우의 수
 * i = 거스름돈 금액
 * dp[거스름돈 금액] = dp[거스름돈 금액] + dp[거스름돈 금액 - 사용할 동전의 금액]
 */
class Solution12907 {

    private static long MOD = 1000000007;

    public int solution(int n, int[] money) {
        long[] dp = new long[100001];
        dp[0] = 1;

        for (int coin : money) {
            for (int price = coin; price < n + 1; price++) {
                dp[price] = dp[price] + dp[price - coin];
            }
        }
        return (int) (dp[n] % MOD);
    }

}

public class P12907 {
    public static void main(String[] args) {
        Solution12907 sol = new Solution12907();
        int ans = 0;
        ans = sol.solution(5, new int[]{1, 2, 5});
        System.out.println(ans);
    }
}
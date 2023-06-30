/**
 * 01:01:28 못풀었음
 */

import java.util.Scanner;

public class B1826 {
    public static void main(String[] args) {
        /**
         *
         * dp[i] : i는 최소로 갈 수 있는 횟수
         * gas[i] : 현재 위치에서 연료
         */


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] gasStation = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            gasStation[i][0] = sc.nextInt();
            gasStation[i][1] = sc.nextInt();
        }
        int l = sc.nextInt();
        int p = sc.nextInt();

        int[] dp = new int[n + 1];
        int[] gas = new int[l + 1];
        int startPoint = 0;
        for (int i = 1; i <= n; i++) {
            if (gasStation[i][0] <= p) {
                dp[i] = 1;
                startPoint = gasStation[i][0];
                gas[i] = p - i + gasStation[i][1];
            }
        }

        for (int i = startPoint + 1, j = 0; i <= l; i++) {
            gas[i] = gas[i - 1] - 1;
            if (gasStation[j++][0] == i) {
                if (gas[i] >= 0) {
                    dp[i] = dp[i - 1] + 1;
                }
            }
        }
    }
}

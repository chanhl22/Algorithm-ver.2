//playtime = 1:39:12

import java.util.Arrays;
import java.util.Scanner;

public class B17404 {
    static int n;
    static int MAX = 10000001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] color = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                color[i][j] = sc.nextInt();
            }
        }
        System.out.println(dp(color));
    }

    private static int dp(int[][] color) {
        int[][] dp = new int[n][3];
        int min = -1;
        for (int i = 0; i < 3; i++) {
            init(dp);
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    dp[0][j] = color[0][j];
                } else {
                    dp[0][j] = MAX;
                }
            }
            for (int j = 1; j < n; j++) {
                dp[j][0] = color[j][0] + Math.min(dp[j - 1][1], dp[j - 1][2]);
                dp[j][1] = color[j][1] + Math.min(dp[j - 1][0], dp[j - 1][2]);
                dp[j][2] = color[j][2] + Math.min(dp[j - 1][0], dp[j - 1][1]);
            }
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    if (min == -1 || dp[n - 1][j] < min) {
                        min = dp[n - 1][j];
                    }
                }
            }
        }
        return min;
    }

    private static void init(int[][] dp) {
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 0);
        }
    }
}

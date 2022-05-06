//playtime = 49:33

import java.util.Scanner;

public class B2302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < 41; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int count = 0;
        int ans = 1;
        int index = 1;
        for (int i = 1; i <= n; i++) {
            if (index <= m && arr[index] == i) {
                index++;
                ans *= dp[count];
                count = 0;
            } else {
                count++;
            }
        }
        ans *= dp[count];
        System.out.println(ans);
    }
}

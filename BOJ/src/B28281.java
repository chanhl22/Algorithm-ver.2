/**
 * playtime = 05:06
 */

import java.util.Scanner;

public class B28281 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int result = cost[i] * x + cost[i + 1] * x;
            if (min > result) {
                min = result;
            }
        }
        System.out.println(min);
    }
}

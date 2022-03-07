//playtime = 15:53

import java.util.Scanner;

public class B9465 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] sticker = new int[2][n + 1];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    sticker[i][j] = sc.nextInt();
                }
            }
            int[][] d = new int[2][n + 1];
            d[0][0] = sticker[0][0];
            d[1][0] = sticker[1][0];
            d[0][1] = sticker[0][1] + sticker[1][0];
            d[1][1] = sticker[1][1] + sticker[0][0];
            for (int i = 2; i < n; i++) {
                d[0][i] = Math.max(Math.max(d[0][i - 2], d[1][i - 2]), d[1][i - 1]) + sticker[0][i];
                d[1][i] = Math.max(Math.max(d[0][i - 2], d[1][i - 2]), d[0][i - 1]) + sticker[1][i];
            }
            System.out.println(Math.max(d[0][n - 1], d[1][n - 1]));
        }
    }
}

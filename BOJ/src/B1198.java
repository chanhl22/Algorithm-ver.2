/**
 * playtime = 44:42
 */

import java.util.Scanner;

public class B1198 {
    private static int n;
    private static int[][] pair;
    private static int max = -1;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = sc.nextInt();
            pair[i][1] = sc.nextInt();
        }
    }

    private static void solution() {
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int temp = calculate(i, j, k);
                    if (max < temp) {
                        max = temp;
                    }
                }
            }
        }
        System.out.printf("%.3f%n", (double) max / 2);
    }

    private static int calculate(int i, int j, int k) {
        int cx = pair[i][0] * pair[j][1] + pair[j][0] * pair[k][1] + pair[k][0] * pair[i][1];
        int cy = pair[i][1] * pair[j][0] + pair[j][1] * pair[k][0] + pair[k][1] * pair[i][0];
        return Math.abs(cx - cy);
    }
}

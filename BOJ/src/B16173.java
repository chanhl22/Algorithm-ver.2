/**
 * playtime = 58:56
 */

import java.util.Scanner;

public class B16173 {
    private static int n;
    private static int[][] map;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
    }

    private static void solution() {
        boolean[][] record = new boolean[n][n];
        record[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n - 1 && j == n - 1) {
                    continue;
                }
                if (record[i][j]) {
                    if (i + map[i][j] >= 0 && i + map[i][j] < n) {
                        record[i + map[i][j]][j] = true;
                    }
                    if (j + map[i][j] >= 0 && j + map[i][j] < n) {
                        record[i][j + map[i][j]] = true;
                    }
                }
            }
        }
        if (record[n - 1][n - 1]) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }
}

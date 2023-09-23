/**
 * playtime = 01:01:00
 */

import java.util.Scanner;

public class B18221 {
    private static int n;
    private static int[][] map;
    private static int px;
    private static int py;
    private static int mx;
    private static int my;

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
                int d = sc.nextInt();
                if (d == 5) {
                    px = i;
                    py = j;
                }
                if (d == 2) {
                    mx = i;
                    my = j;
                }
                map[i][j] = d;
            }
        }
    }

    private static void solution() {
        if (!checkDist()) {
            System.out.println("0");
            return;
        }
        if (!checkStudent()) {
            System.out.println("0");
            return;
        }
        System.out.println("1");
    }

    private static boolean checkDist() {
        return Math.pow(px - mx, 2) + Math.pow(py - my, 2) >= 25;
    }

    private static boolean checkStudent() {
        int sx = Math.min(px, mx);
        int ex = Math.max(px, mx);
        int sy = Math.min(py, my);
        int ey = Math.max(py, my);

        int count = 0;
        for (int i = sx; i <= ex; i++) {
            for (int j = sy; j <= ey; j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }
        return count >= 3;
    }
}

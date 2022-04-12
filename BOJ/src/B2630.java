//playtime = 01:01:54

import java.util.Scanner;

public class B2630 {
    static int[][] map;
    static boolean[][] visited;
    static int ansZero;
    static int ansOne;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        go(n, 0, 0);
        System.out.println(ansZero);
        System.out.println(ansOne);
    }

    private static void go(int index, int sx, int sy) {
        if (index == 0 || visited[sx][sy] == true) {
            return;
        }
        if (visited[sx][sy] == false) {
            check(index, sx, sy);
            go(index / 2, sx, sy);
            go(index / 2, sx, sy + index / 2);
            go(index / 2, sx + index / 2, sy);
            go(index / 2, sx + index / 2, sy + index / 2);
        }
    }

    private static void check(int index, int sx, int sy) {
        boolean ok = true;
        for (int i = sx; i < sx + index; i++) {
            for (int j = sy; j < sy + index; j++) {
                if (map[i][j] != map[sx][sy]) {
                    ok = false;
                }
            }
        }
        if (ok) {
            if (map[sx][sy] == 0) {
                ansZero++;
            } else {
                ansOne++;
            }
            for (int i = sx; i < sx + index; i++) {
                for (int j = sy; j < sy + index; j++) {
                    visited[i][j] = true;
                }
            }
        }
    }
}
/**
 * playtime = 24:58
 */

import java.util.Arrays;
import java.util.Scanner;

public class B5212 {
    private static int x;
    private static int y;
    private static char[][] map;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt() + 2;
        y = sc.nextInt() + 2;
        map = new char[x][y];
        for (int i = 0; i < x; i++) {
            Arrays.fill(map[i], '.');
        }
        for (int i = 1; i < x - 1; i++) {
            String input = sc.next();
            for (int j = 1; j < y - 1; j++) {
                map[i][j] = input.charAt(j - 1);
            }
        }
    }

    private static void solution() {
        boolean[][] isSink = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (map[i][j] == 'X') {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < x && ny >= 0 && ny < y) {
                            if (map[nx][ny] == '.') {
                                count++;
                            }
                        }
                    }
                    if (count >= 3) {
                        isSink[i][j] = true;
                    }
                }
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (isSink[i][j]) {
                    map[i][j] = '.';
                }
            }
        }

        int sx = -1;
        int sy = -1;
        int ex = -1;
        int ey = -1;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (map[i][j] == 'X') {
                    if (sx == -1 || sx > i) {
                        sx = i;
                    }
                    if (ex == -1 || ex < i) {
                        ex = i;
                    }
                    if (sy == -1 || sy > j) {
                        sy = j;
                    }
                    if (ey == -1 || ey < j) {
                        ey = j;
                    }
                }
            }
        }

        for (int i = Math.min(sx, ex); i <= Math.max(sx, ex); i++) {
            for (int j = Math.min(sy, ey); j <= Math.max(sy, ey); j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}

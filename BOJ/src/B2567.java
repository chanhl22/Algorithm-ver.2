/**
 * playtime = 34:25
 */

import java.util.Scanner;

public class B2567 {
    private static int n;
    private static int[][] pair;
    private static final int[][][] map = new int[102][102][4];
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

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
        initMap();
        updateMap();
        findLength();
        answer();
    }

    private static void initMap() {
        for (int i = 0; i < 102; i++) {
            for (int j = 0; j < 102; j++) {
                for (int k = 0; k < 4; k++) {
                    map[i][j][k] = -1;
                }
            }
        }
    }

    private static void updateMap() {
        for (int i = 0; i < n; i++) {
            for (int j = pair[i][0]; j < pair[i][0] + 10; j++) {
                for (int k = pair[i][1]; k < pair[i][1] + 10; k++) {
                    map[j][k][0] = 0;
                    map[j][k][1] = 0;
                    map[j][k][2] = 0;
                    map[j][k][3] = 0;
                }
            }
        }
    }

    private static void findLength() {
        for (int i = 0; i < 102; i++) {
            for (int j = 0; j < 102; j++) {
                for (int k = 0; k < 4; k++) {
                    if (map[i][j][k] == 0) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < 102 && ny >= 0 && ny < 102 && map[nx][ny][k] == -1) {
                            map[i][j][k] = 1;
                        }
                    }
                }
            }
        }
    }

    private static void answer() {
        int sum = 0;
        for (int i = 0; i < 102; i++) {
            for (int j = 0; j < 102; j++) {
                for (int k = 0; k < 4; k++) {
                    if (map[i][j][k] == 1) {
                        sum++;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}

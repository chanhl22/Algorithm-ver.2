/**
 * playtime = 19:27
 */

import java.util.Scanner;

public class B1996 {
    public static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                if (c == '.') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = c - '0';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == -1) {
                    int count = count(map, i, j, n);
                    if (count >= 10) {
                        sb.append("M");
                    } else {
                        sb.append(count);
                    }
                } else {
                    sb.append("*");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int count(int[][] map, int x, int y, int n) {
        int result = 0;
        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (map[nx][ny] != -1) {
                    result += map[nx][ny];
                }
            }
        }
        return result;
    }
}

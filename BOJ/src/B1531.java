/**
 * playtime = 22:35
 */

import java.util.Scanner;

public class B1531 {
    private static int n;
    private static int m;
    private static int[][] pair;
    private static final int[][] map = new int[100][100];

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pair = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                pair[i][j] = sc.nextInt() - 1;
            }
        }
    }

    private static void solution() {
        for (int i = 0; i < n; i++) {
            fillMap(i);
        }

        int result = findPicture();

        System.out.println(result);
    }

    private static void fillMap(int index) {
        int x1 = pair[index][0];
        int y1 = pair[index][1];
        int x2 = pair[index][2];
        int y2 = pair[index][3];

        int maxX = Math.max(x1, x2);
        int minX = Math.min(x1, x2);
        int maxY = Math.max(y1, y2);
        int minY = Math.min(y1, y2);

        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                map[i][j]++;
            }
        }
    }

    private static int findPicture() {
        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] > m) {
                    result++;
                }
            }
        }
        return result;
    }
}

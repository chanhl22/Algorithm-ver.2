//playtime = 22:12

import java.util.Scanner;

public class B11660 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int[][] d = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                d[i][j] = d[i - 1][j] + d[i][j - 1] - d[i - 1][j - 1] + map[i][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int sx = sc.nextInt();
            int sy = sc.nextInt();
            int ex = sc.nextInt();
            int ey = sc.nextInt();
            sb.append(d[ex][ey] - d[sx - 1][ey] - d[ex][sy - 1] + d[sx - 1][sy - 1]);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}

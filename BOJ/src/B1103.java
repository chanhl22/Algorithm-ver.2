//playtime = 01:17:43

import java.util.Scanner;

public class B1103 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] check;
    static int[][] dp;
    static int ans = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        map = new int[n][m];
        check = new boolean[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                char temp = s.charAt(j);
                if (temp == 'H') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = temp - '0';
                }
            }
        }
        check[0][0] = true;
        dfs(0, 0, 1);
        System.out.println(ans);
    }

    private static void dfs(int sx, int sy, int cnt) {
        if (ans < cnt) {
            ans = cnt;
        }
        dp[sx][sy] = cnt;
        for (int k = 0; k < 4; k++) {
            int num = map[sx][sy];
            int nx = dx[k] * num + sx;
            int ny = dy[k] * num + sy;
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != -1) {
                if (check[nx][ny] == true) {
                    System.out.println(-1);
                    System.exit(0);
                }
                if (dp[nx][ny] > cnt) continue;
                check[nx][ny] = true;
                dfs(nx, ny, cnt + 1);
                check[nx][ny] = false;
            }
        }
    }
}

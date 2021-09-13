import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1600 {
    static int[] dx = {0, 0, -1, 1, -1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-1, 1, 0, 0, -2, -1, 1, 2, 2, 1, -1, -2};
    static int[] cost = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int[][][] d = new int[n][m][l + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(d[i][j], -1);
            }
        }
        q.add(0);
        q.add(0);
        q.add(0);
        d[0][0][0] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            int t = q.remove();
            for (int k = 0; k < 12; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                int nt = t + cost[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (nt <= l && d[nx][ny][nt] == -1 && a[nx][ny] != 1) {
                        q.add(nx);
                        q.add(ny);
                        q.add(nt);
                        d[nx][ny][nt] = d[x][y][t] + 1;
                    }
                }
            }
        }
        int ans = -1;
        for (int i = 0; i < l + 1; i++) {
            if(d[n-1][m-1][i] == -1) continue;
            if (ans == -1) {
                ans = d[n-1][m-1][i];
            } else if (d[n-1][m-1][i] < ans) {
                ans = d[n-1][m-1][i];
            }
            //code deduplication Refactoring
            /*
            if (ans == -1 || d[n-1][m-1][i] < ans) {
                ans = d[n-1][m-1][i];
            }
            */
        }
        System.out.println(ans);
    }
}

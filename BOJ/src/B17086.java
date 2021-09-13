import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B17086 {
    static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        int[][] d = new int[n][m];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                d[i][j] = -1;
                if (a[i][j] == 1) {
                    q.add(i);
                    q.add(j);
                    d[i][j] = 0;
                }
            }
        }
        //bfs
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (d[nx][ny] != -1) continue;
                    d[nx][ny] = d[x][y] + 1;
                    q.add(nx);
                    q.add(ny);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ans < d[i][j]) {
                    ans = d[i][j];
                }
            }
        }
        System.out.println(ans);
    }
}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1012 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static void bfs(int x, int y, boolean[][] check, int n, int m, int[][] a) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(y);
        check[x][y] = true;
        while (!q.isEmpty()) {
            int px = q.remove();
            int py = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = px + dx[k];
                int ny = py + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (a[nx][ny] == 1 && check[nx][ny] == false) {
                        q.add(nx);
                        q.add(ny);
                        check[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int p = sc.nextInt();
            int[][] a = new int[n][m];
            for (int i = 0; i < p; i++) {
                int y = sc.nextInt();
                int x = sc.nextInt();
                a[x][y] = 1;
            }
            int ans = 0;
            boolean check[][] = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] == 1 && check[i][j] == false) {
                        bfs(i, j, check, n, m, a);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}

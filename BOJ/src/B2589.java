import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2589 {
    static int n;
    static int m;
    static char[][] a;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int bfs(int i, int j) {
        Queue<Integer> q = new LinkedList<>();
        boolean[][] check = new boolean[n][m];
        int[][] dist = new int[n][m];
        q.add(i);
        q.add(j);
        check[i][j] = true;
        dist[i][j] = 0;
        while(!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (check[nx][ny] == false && a[nx][ny] == 'L') {
                        q.add(nx);
                        q.add(ny);
                        check[nx][ny] = true;
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                }
            }
        }
        int ans = 0;
        for (int l1 = 0; l1 < n; l1++) {
            for (int l2 = 0; l2 < m; l2++) {
                if (ans < dist[l1][l2]) {
                    ans = dist[l1][l2];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.next().toCharArray();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'W') continue;
                int temp = bfs(i, j);
                if (ans < temp) {
                    ans = temp;
                }
            }
        }
        System.out.println(ans);
    }
}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7569 {
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();
        int[][][] a = new int[n][m][h];
        int[][][] dist = new int[n][m][h];
        boolean[][][] check = new boolean[n][m][h];
        Queue<Integer> q = new LinkedList<>();
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j][k] = sc.nextInt();
                    if (a[i][j][k] == 1) {
                        q.add(i);
                        q.add(j);
                        q.add(k);
                        check[i][j][k] = true;
                        dist[i][j][k] = 1;
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            int z = q.remove();
            for (int k = 0; k < 6; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                int nz = z + dz[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && nz >= 0 && nz < h) {
                    if (check[nx][ny][nz] == false && a[nx][ny][nz] != -1) {
                        check[nx][ny][nz] = true;
                        dist[nx][ny][nz] = dist[x][y][z] + 1;
                        q.add(nx);
                        q.add(ny);
                        q.add(nz);
                    }
                }
            }
        }
        int ans = 0;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int temp = dist[i][j][k];
                    if (ans < temp) {
                        ans = temp;
                    } else if (temp == 0 && a[i][j][k] != -1) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(ans - 1);
    }
}

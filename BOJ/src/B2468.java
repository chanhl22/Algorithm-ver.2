import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2468 {
    static int n;
    static int[][] a;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static void bfs(int i, int j, boolean[][] check, int rain) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        q.add(j);
        check[i][j] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (rain < a[nx][ny] && check[nx][ny] == false) {
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
        n = sc.nextInt();
        a = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if (max < a[i][j]) {
                    max = a[i][j];
                }
            }
        }
        int ans = 0;
        for (int rain = 0; rain <= max; rain++) {
            boolean[][] check = new boolean[n][n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[i][j] <= rain) continue;
                    if (check[i][j] != false) continue;
                    bfs(i, j, check, rain);
                    cnt++;
                }
            }
            if (ans < cnt) {
                ans = cnt;
            }
        }
        System.out.println(ans);
    }
}

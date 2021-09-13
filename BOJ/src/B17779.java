import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B17779 {
    static int n;
    static int[][] a;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static void bfs(int[][] d, int x, int y, int value) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(y);
        d[x][y] = value;
        while (!q.isEmpty()) {
            x = q.remove();
            y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (d[nx][ny] == 0) {
                        d[nx][ny] = value;
                        q.add(nx);
                        q.add(ny);
                    }
                }
            }
        }
    }

    static int go(int x, int y, int d1, int d2) {
        int ans = 0;
        int[][] d = new int[n][n];
        for (int i = 0; i <= d1; i++) {
            d[x + i][y - i] = 5;
            d[x + d2 + i][y + d2 - i] = 5;
        }
        for (int i = 0; i <= d2; i++) {
            d[x + i][y + i] = 5;
            d[x + d1 + i][y - d1 + i] = 5;
        }
        for (int i = 0; i < y - d1; i++) {
            d[x + d1][i] = 3;
        }
        for (int i = 0; i < x; i++) {
            d[i][y] = 1;
        }
        for (int i = n - 1; i > y + d2; i--) {
            d[x + d2][i] = 2;
        }
        for (int i = n - 1; i > x + d2 + d1; i--) {
            d[i][y - d1 + d2] = 4;
        }
        bfs(d, 0, 0, 1);
        bfs(d, 0, n - 1, 2);
        bfs(d, n - 1, 0, 3);
        bfs(d, n - 1, n - 1, 4);
        int[] record = new int[5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (d[i][j] == 0) d[i][j] = 5;
                record[d[i][j] - 1] += a[i][j];
            }
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            max = Math.max(record[i], max);
            min = Math.min(record[i], min);
        }
        ans = max - min;
        /*
        Arrays.sort(record);
        ans = cnt[4] - cnt[0];
         */
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int x = 0; x < n; x++) { // x
            for (int y = 0; y < n; y++) { // y
                for (int d1 = 1; d1 < n; d1++) { // d1
                    for (int d2 = 1; d2 < n; d2++) { // d2
                        if (0 <= y - d1 && y + d2 < n) {
                            if (x + d1 + d2 < n) {
                                int temp = go(x, y, d1, d2);
                                if (ans > temp) {
                                    ans = temp;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}

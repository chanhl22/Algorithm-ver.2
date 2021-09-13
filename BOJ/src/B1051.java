import java.util.Scanner;

public class B1051 {
    static int n;
    static int m;
    static int small;
    static int[][] a;

    static int find(int x, int y) {
        int res = 1;
        int nx = x;
        int ny = y;
        for (int i = 1; i < small; i++) {
            nx += 1;
            ny += 1;
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (a[nx][y] == a[x][ny] && a[nx][y] == a[nx][ny] && a[nx][y] == a[x][y]) {
                res = (i + 1) * (i + 1);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        small = Math.min(n, m);
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int temp = find(i, j);
                if (ans < temp) {
                    ans = temp;
                }
            }
        }
        System.out.println(ans);
    }
}

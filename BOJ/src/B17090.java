import java.util.Arrays;
import java.util.Scanner;

public class B17090 {
    static int n;
    static int m;
    static char[][] a;
    static int[][] d;

    static int go(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return 1;
        }
        if(d[x][y] != -1) return d[x][y];
        d[x][y] = 0;
        if (a[x][y] == 'U') {
            d[x][y] = go(x - 1, y);
        } else if (a[x][y] == 'R') {
            d[x][y] = go(x, y + 1);
        } else if (a[x][y] == 'D') {
            d[x][y] = go(x + 1, y);
        } else if (a[x][y] == 'L') {
            d[x][y] = go(x, y - 1);
        }
        return d[x][y];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];
        d = new int[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.next().toCharArray();
            Arrays.fill(d[i], -1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += go(i, j);
            }
        }
        System.out.println(ans);
    }
}

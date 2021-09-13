import java.util.Scanner;

public class B16958 {
    static int n;
    static int t;
    static int[] s;
    static int[] x;
    static int[] y;
    static int[][] dist;

    static int near(int c) {
        int ans = -1;
        int where = -1;
        for (int i = 0; i < n; i++) {
            if (s[i] == 0) continue;
            if (ans == -1 || ans > dist[c][i]) {
                ans = dist[c][i];
                where = i;
            }
        }
        //리턴값은 움직일 칸의 번호, 거리가 아님
        return where;
    }

    static int calc(int x, int y) {
        int ans = dist[x][y];
        if (s[x] == 1 && s[y] == 1) { // 안써도 검사하긴 하네
            if (ans > t) {
                ans = t;
            }
        }
        int tx = near(x);
        int ty = near(y);
        if (tx != -1 && ty != -1) {
            int temp = dist[x][tx] + t + dist[ty][y];
            if (ans > temp) {
                ans = temp;
            }
        }
        return ans;
    }

    //i는 i번 도시를 의미함, j도 j번 도시를 의미함
    static int cal_dist(int i, int j) {
        int t1 = x[i] - x[j];
        int t2 = y[i] - y[j];
        if (t1 < 0) t1 = -t1;
        if (t2 < 0) t2 = -t2;
        return t1 + t2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        s = new int[n];
        x = new int[n];
        y = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        dist = new int[n][n]; //no teleport, i to j time taken
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = dist[j][i] = cal_dist(i, j);
            }
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            System.out.println(calc(a, b));
        }
    }
}

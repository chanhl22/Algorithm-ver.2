import java.util.ArrayList;
import java.util.Scanner;

class CCTV {
    int type;
    int x;
    int y;
    int dir;

    public CCTV(int type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.dir = 0;
    }
}

public class B15683 {
    static int[][] a;
    static int n;
    static int m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static void check(int[][] b, int x, int y, int dir) {
        int i = x;
        int j = y;
        while (i >= 0 && i < n && j >= 0 && j < m) {
            if (a[i][j] == 6) break;
            b[i][j] = a[x][y];
            i += dx[dir];
            j += dy[dir];
        }
    }

    static int go(ArrayList<CCTV> cctvs, int index) {
        if (index == cctvs.size()) {
            int[][] b = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    b[i][j] = a[i][j];
                }
            }
            for (CCTV c : cctvs) {
                int what = c.type;
                int x = c.x;
                int y = c.y;
                int dir = c.dir;
                if (what == 1) {
                    check(b, x, y, dir);
                } else if (what == 2) {
                    check(b, x, y, dir);
                    check(b, x, y, (dir + 2) % 4);
                } else if (what == 3) {
                    check(b, x, y, dir);
                    check(b, x, y, (dir + 1) % 4);
                } else if (what == 4) {
                    check(b, x, y, dir);
                    check(b, x, y, (dir + 1) % 4);
                    check(b, x, y, (dir + 2) % 4);
                } else if (what == 5) {
                    check(b, x, y, dir);
                    check(b, x, y, (dir + 1) % 4);
                    check(b, x, y, (dir + 2) % 4);
                    check(b, x, y, (dir + 3) % 4);
                }
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (b[i][j] == 0) {
                        cnt += 1;
                    }
                }
            }
            return cnt;
        }
        int ans = 100;
        for (int i = 0; i < 4; i++) {
            cctvs.get(index).dir = i;
            int temp = go(cctvs, index + 1);
            if (ans > temp) {
                ans = temp;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        ArrayList<CCTV> cctvs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] >= 1 && a[i][j] <= 5) {
                    cctvs.add(new CCTV(a[i][j], i, j));
                }
            }
        }
        System.out.println(go(cctvs, 0));
    }
}

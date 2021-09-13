import java.util.*;

class Pair17 {
    int x;
    int y;

    public Pair17(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class B17141 {
    static int n;
    static int m;
    static int ans = -1;
    static int[][] a;
    static ArrayList<Pair17> v = new ArrayList<Pair17>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static void bfs() {
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], -1);
        }
        Queue<Pair17> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 3) {
                    q.add(new Pair17(i, j));
                    d[i][j] = 0;
                }
            }
        }
        while (!q.isEmpty()) {
            Pair17 p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (a[nx][ny] != 1 && d[nx][ny] == -1){
                        d[nx][ny] = d[x][y] + 1;
                        q.add(new Pair17(nx,ny));
                    }
                }
            }
        }
        int cur = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != 1) {
                    if (d[i][j] == -1) return;
                    if (cur < d[i][j]) {
                        cur = d[i][j];
                    }
                }
            }
        }
        if (ans == -1 || ans > cur) {
            ans = cur;
        }
    }

    static void go(int index, int cnt) {
        if (index == v.size()) {
            if (cnt == m) {
                bfs();
            }
            return;
        }
        int x = v.get(index).x;
        int y = v.get(index).y;
        a[x][y] = 3;
        go(index + 1, cnt + 1);
        a[x][y] = 0;
        go(index + 1, cnt);
    }

//    ----- Another Solution -----
//    static void go(int index, int cnt) {
//        if (index == v.size()) {
//            if (cnt == m) {
//                bfs();
//            }
//        } else {
//            int x = v.get(index).x;
//            int y = v.get(index).y;
//            a[x][y] = 3;
//            go(index+1, cnt+1);
//            a[x][y] = 0;
//            go(index+1, cnt);
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 2) {
                    v.add(new Pair17(i, j));
                }
            }
        }
        go(0, 0);
        System.out.println(ans);
    }
}

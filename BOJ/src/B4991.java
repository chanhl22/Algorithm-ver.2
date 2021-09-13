import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair16 {
    int first;
    int second;

    public Pair16(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class B4991 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int[][] bfs(String[] a, int sx, int sy) {
        int n = a.length;
        int m = a[0].length();
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = -1;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(sx);
        q.add(sy);
        dist[sx][sy] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (a[nx].charAt(ny) != 'x' && dist[nx][ny] == -1) {
                        q.add(nx);
                        q.add(ny);
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                }
            }
        }
        return dist;
    }

    static boolean next(int[] p) {
        int i = p.length - 1;
        while (i > 0 && p[i] <= p[i - 1]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }
        int j = p.length - 1;
        while (p[j] <= p[i - 1]) {
            j--;
        }

        int temp = p[i - 1];
        p[i - 1] = p[j];
        p[j] = temp;

        j = p.length - 1;
        while (i < j) {
            temp = p[i];
            p[i] = p[j];
            p[j] = temp;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            if (m == 0 && n == 0) break;

            String[] a = new String[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.next();
            }
            //. : clean space
            //* : dirty space
            //x : furniture
            //o : robot
            ArrayList<Pair16> b = new ArrayList<>(); // * position
            b.add(new Pair16(0,0));
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i].charAt(j) == 'o') {
                        b.set(0, new Pair16(i, j));
                    }
                    if (a[i].charAt(j) == '*') {
                        b.add(new Pair16(i, j));
                    }
                }
            }
            int l = b.size();
            int[][] d = new int[l][l]; //Record dist
            boolean ok = false;
            for (int i = 0; i < l; i++) {
                int dist[][] = bfs(a, b.get(i).first, b.get(i).second); //Distance from each "*" starting point
                for (int j = 0; j < l; j++) {
                    d[i][j] = dist[b.get(j).first][b.get(j).second]; //Save the location of "*".
                    if (d[i][j] == -1) {
                        ok = true;
                    }
                }
            }
            if (ok) {
                System.out.println(-1);
                continue;
            }
            int[] p = new int[l - 1]; // index : dirty space, exception start space
            for (int i = 0; i < l - 1; i++) {
                p[i] = i + 1;
            }
            int ans = Integer.MAX_VALUE;
            do {
                int now = d[0][p[0]];
                for (int i = 0; i < l - 2; i++) {
                    now += d[p[i]][p[i + 1]];
                }
                if (now < ans) {
                    ans = now;
                }
            } while (next(p));
            System.out.println(ans);
        }
    }
}

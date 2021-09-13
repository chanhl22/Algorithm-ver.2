import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair14 {
    int dist;
    int x;
    int y;

    Pair14(int dist, int x, int y) {
        this.dist = dist;
        this.x = x;
        this.y = y;
    }
}

public class B16236 {
    static int n;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static Pair14 bfs(int sx, int sy, int size, int[][] a) {
        ArrayList<Pair14> ans = new ArrayList<>(); //To include all possible spaces
        int[][] d = new int[n][n]; //bfs dist
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = -1;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(sx);
        q.add(sy);
        d[sx][sy] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (d[nx][ny] == -1) {
                        boolean ok = false;
                        boolean eat = false;
                        //Move blank
                        if (a[nx][ny] == 0) {
                            ok = true;
                            //Eat fish & Move
                        } else if (a[nx][ny] < size) {
                            ok = eat = true;
                            // Can't eat fish & Move
                        } else if (a[nx][ny] == size) {
                            ok = true;
                        }
                        if (ok) {
                            q.add(nx);
                            q.add(ny);
                            d[nx][ny] = d[x][y] + 1;
                            //If shark can eat, add to ans arraylist
                            if (eat) {
                                ans.add(new Pair14(d[nx][ny], nx, ny));
                            }
                        }
                    }
                }
            }
        }
        //if empty ans arraylist
        if (ans.isEmpty()) {
            return null;
        }
        //Decide where to visit first
        Pair14 best = ans.get(0);
        for (Pair14 p : ans) {
            if (best.dist > p.dist) {
                best = p;
            } else if (best.dist == p.dist && best.x > p.x) {
                best = p;
            } else if (best.dist == p.dist && best.x == p.x && best.y > p.y) {
                best = p;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int x = 0; //shark row
        int y = 0; //shark col
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 9) {
                    a[i][j] = 0;
                    x = i;
                    y = j;
                }
            }
        }
        int ans = 0; //dist
        int size = 2; // shark size
        int exp = 0; // Required to level up sharks
        while (true) {
            Pair14 p = bfs(x, y, size, a);
            if (p == null) break;
            a[p.x][p.y] = 0;
            ans += p.dist;
            exp += 1;
            if (exp == size){
                size += 1;
                exp = 0;
            }
            x = p.x;
            y = p.y;
        }
        System.out.println(ans);
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B3184 {
    static int n;
    static int m;
    static char[][] a;
    static boolean[][] check;
    static int wolf = 0;
    static int sheep = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static void bfs(int i, int j) {
        int wolf_cnt = 0;
        int sheep_cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        q.add(j);
        check[i][j] = true;
        if (a[i][j] == 'v') {
            wolf_cnt++;
        }
        if (a[i][j] == 'o') {
            sheep_cnt++;
        }
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(check[nx][ny] == false && a[nx][ny] != '#') {
                        if (a[nx][ny] == 'v') {
                            wolf_cnt++;
                        }
                        if (a[nx][ny] == 'o') {
                            sheep_cnt++;
                        }
                        q.add(nx);
                        q.add(ny);
                        check[nx][ny] = true;
                    }
                }
            }
        }
        if (wolf_cnt < sheep_cnt) {
            sheep += sheep_cnt;
        } else {
            wolf += wolf_cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
            }
        }
        check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check[i][j] == false && a[i][j] != '#') {
                    bfs(i, j);
                }
            }
        }
        System.out.println(sheep+ " " + wolf);
    }
}

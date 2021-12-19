//playtime = 2:01:10

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B5427 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static int n;
    static int m;
    static char[][] map;
    static Queue<Integer> fire;
    static StringBuilder sb = new StringBuilder();
    static boolean ok;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            ok = false;
            String[] s = br.readLine().split(" ");
            m = Integer.parseInt(s[0]);
            n = Integer.parseInt(s[1]);
            map = new char[n][m];
            int cur_x = 0;
            int cur_y = 0;
            fire = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '@') {
                        cur_x = i;
                        cur_y = j;
                    }
                    if (map[i][j] == '*') {
                        fire.add(i);
                        fire.add(j);
                    }
                }
            }
            bfs(cur_x, cur_y);
            if (!ok) {
                sb.append("IMPOSSIBLE");
                sb.append('\n');
            }
        }
        System.out.print(sb.toString());
    }

    private static void bfs(int cur_x, int cur_y) {
        Queue<Integer> q = new LinkedList<>();
        q.add(cur_x);
        q.add(cur_y);
        int[][] dist = new int[n][m];
        while (!q.isEmpty()) {
            //fire
            int len = fire.size();
            for (int i = 0; i < len; i += 2) {
                int x = fire.remove();
                int y = fire.remove();
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (map[nx][ny] != '*' && map[nx][ny] != '#') {
                            map[nx][ny] = '*';
                            fire.add(nx);
                            fire.add(ny);
                        }
                    }
                }
            }
            //상근
            len = q.size();
            for (int i = 0; i < len; i += 2) {
                int x = q.remove();
                int y = q.remove();
                if (x == 0 || x == n - 1 || y == 0 || y == m - 1) {
                    sb.append(dist[x][y] + 1);
                    sb.append('\n');
                    ok = true;
                    return;
                }
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (map[nx][ny] == '.') {
                            q.add(nx);
                            q.add(ny);
                            map[nx][ny] = '@';
                            dist[nx][ny] = dist[x][y] + 1;
                        }
                    }
                }
            }
        }
    }
}

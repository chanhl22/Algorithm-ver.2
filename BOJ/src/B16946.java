import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class B16946 {
    static int n;
    static int m;
    static int[][] a;
    static boolean[][] check;
    static int[][] group;
    static ArrayList<Integer> group_size = new ArrayList<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void bfs(int sx, int sy) {
        Queue<Integer> q = new LinkedList<>();
        int g = group_size.size();
        q.add(sx);
        q.add(sy);
        check[sx][sy] = true;
        group[sx][sy] = g;
        int cnt = 1;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (a[nx][ny] == 0 && check[nx][ny] == false) {
                        q.add(nx);
                        q.add(ny);
                        check[nx][ny] = true;
                        group[nx][ny] = g;
                        cnt += 1;
                    }
                }
            }
        }
        group_size.add(cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] st = bf.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);
        a = new int[n][m];
        check = new boolean[n][m];
        group = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = bf.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
                group[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0 && check[i][j] == false) {
                    bfs(i, j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0) {
                    bw.write("0");
                } else {
                    HashSet<Integer> near = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < n && y >= 0 && y < m) {
                            if (a[x][y] == 0) {
                                near.add(group[x][y]);
                            }
                        }
                    }
                    int ans = 1;
                    for (int g : near) {
                        ans += group_size.get(g);
                    }
                    bw.write(String.valueOf(ans%10));
                }
            }
            bw.write("\n");
        }
        bw.flush();
    }
}

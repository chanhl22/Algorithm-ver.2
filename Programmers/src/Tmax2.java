import java.util.LinkedList;
import java.util.Queue;

class Solution79 {
    static int n;
    static int m;
    static int[][] map;
    static int ans = 0;
    static boolean[][] c;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public int solution(String[] grid) {
        int answer = -1;
        n = grid.length;
        m = grid[0].length();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == 'a') {
                    map[i][j] = 1;
                } else if (grid[i].charAt(j) == 'b') {
                    map[i][j] = 2;
                } else if (grid[i].charAt(j) == 'c') {
                    map[i][j] = 3;
                } else {
                    map[i][j] = 4;
                }
            }
        }
        go(0);
        answer = ans;
        return answer;
    }

    private void go(int index) {
        if (index == n * m - 1) {
            if (check()) {
                ans++;
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 4) {
                    map[i][j] = 1;
                    go(index + i * n + j);
                    map[i][j] = 4;
                    map[i][j] = 2;
                    go(index + i * n + j);
                    map[i][j] = 4;
                    map[i][j] = 3;
                    go(index + i * n + j);
                    map[i][j] = 4;
                }
            }
        }
    }

    private boolean check() {
        int ax= 0;
        int ay= 0;
        int bx= 0;
        int by= 0;
        int cx= 0;
        int cy= 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    ax = i;
                    ay = j;
                } else if(map[i][j] == 2) {
                    bx = i;
                    by = j;
                } else if(map[i][j] == 3) {
                    cx = i;
                    cy = j;
                }
            }
        }
        c = new boolean[n][m];
        bfs(ax, ay);
        bfs(bx, by);
        bfs(cx, cy);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (c[i][j] == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private void bfs(int sx, int sy) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sx);
        q.add(sy);
        c[sx][sy] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (c[nx][ny] == false && map[nx][ny] == map[sx][sy]) {
                        q.add(nx);
                        q.add(ny);
                        c[nx][ny] = true;
                    }
                }
            }
        }
    }
}


public class Tmax2 {
    public static void main(String[] args) {
        Solution79 sol = new Solution79();
        int ans = 0;
//        ans = sol.solution(new String[]{"aa?"});
        ans = sol.solution(new String[]{"??b", "abc", "cc?"});
        System.out.println(ans);
    }
}
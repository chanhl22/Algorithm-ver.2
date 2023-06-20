/**
 * playtime = 46:39
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair169199 {
    int x;
    int y;

    public Pair169199(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution169199 {

    public static final int[] dx = {0, 0, -1, 1};
    public static final int[] dy = {-1, 1, 0, 0};
    public static int n = 0;
    public static int m = 0;
    public static int sx = 0;
    public static int sy = 0;
    public static int ex = 0;
    public static int ey = 0;

    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'R') {
                    sx = i;
                    sy = j;
                }
                if (map[i][j] == 'G') {
                    ex = i;
                    ey = j;
                }
            }
        }

        return bfs(map);
    }

    private int bfs(char[][] map) {
        int[][] isVisit = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(isVisit[i], -1);
        }
        isVisit[sx][sy] = 0;
        Queue<Pair169199> q = new LinkedList<>();
        q.add(new Pair169199(sx, sy));

        while (!q.isEmpty()) {
            Pair169199 p = q.remove();
            for (int k = 0; k < 4; k++) {
                Pair169199 np = move(p, k, map);
                if (isVisit[np.x][np.y] == -1) {
                    q.add(np);
                    isVisit[np.x][np.y] = isVisit[p.x][p.y] + 1;
                }
            }
        }

        return isVisit[ex][ey];
    }

    private Pair169199 move(Pair169199 p, int dir, char[][] map) {
        int x = p.x;
        int y = p.y;
        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 'D') {
                return new Pair169199(x, y);
            }
            x = nx;
            y = ny;
        }
    }
}

public class P169199 {
    public static void main(String[] args) {
        Solution169199 sol = new Solution169199();
        int ans = 0;
//        ans = sol.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."});
        ans = sol.solution(new String[]{".D.R", "....", ".G..", "...D"});
        System.out.println(ans);
    }
}
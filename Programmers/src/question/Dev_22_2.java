package question;

import java.util.LinkedList;
import java.util.Queue;

class Solution121 {
    static int n;
    static int m;
    static int[][] map;
    static int result = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public int solution(String[] grid) {
        int answer = -1;
        n = grid.length;
        m = grid[0].length();
        /**
         * a = 1
         * b = 2
         * c = 3
         * ? = 4
         */
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == '?') {
                    map[i][j] = 4;
                } else if (grid[i].charAt(j) == 'a') {
                    map[i][j] = 1;
                } else if (grid[i].charAt(j) == 'b') {
                    map[i][j] = 2;
                } else if (grid[i].charAt(j) == 'c') {
                    map[i][j] = 3;
                }
            }
        }
        go(0);
        answer = result;
        return answer;
    }

    private void go(int index) {
        if (findQuestionMark()) {
            if (check()) {
                result++;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 1; k < 4; k++) {
                    if (map[i][j] == 4) {
                        map[i][j] = k;
                        go(index + 1);
                        map[i][j] = 4;
                    }
                }
            }
        }
    }

    private boolean findQuestionMark() {
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 4) {
                    ok = false;
                }
            }
        }
        return ok;
    }

    private boolean check() {
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == true) continue;
                bfs(i, j, visited);
                count++;
            }
        }
        if (count <= 3) {
            return true;
        } else {
            return false;
        }
    }

    private void bfs(int sx, int sy, boolean[][] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sx);
        q.add(sy);
        visited[sx][sy] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (visited[nx][ny] == false && map[nx][ny] == map[sx][sy]) {
                        q.add(nx);
                        q.add(ny);
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}


public class Dev_22_2 {
    public static void main(String[] args) {
        Solution121 sol = new Solution121();
        int ans = 0;
        ans = sol.solution(new String[]{"??b", "abc", "cc?"});
//        ans = sol.solution(new String[]{"aa?"});
        System.out.println(ans);
    }
}
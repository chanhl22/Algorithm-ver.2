package question;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution131 {

    static int x;
    static int y;
    static int count;
    static int max;
    static int[][] answer;
    static boolean[][] check;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public int[][] solution(int n, boolean horizontal) {
        x = 0;
        y = 0;
        count = 1;
        max = 0;
        answer = new int[n][n];
        check = new boolean[n][n];
        answer[0][0] = count;
        check[0][0] = true;
        while (n-- > 1) {
            if (horizontal) { // 수평
                y++;
            } else { // 수직
                x++;
            }
            max = Math.max(x, y);
            moveArrange();
            horizontal = bfs(horizontal);
        }
        return answer;
    }

    private boolean bfs(boolean horizontal) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(y);
        answer[x][y] = ++count;
        while (!q.isEmpty()) {
            int qx = q.remove();
            int qy = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = qx + dx[k];
                int ny = qy + dy[k];
                if (nx >= 0 && nx <= max && ny >= 0 && ny <= max) {
                    if (answer[nx][ny] == 0) {
                        q.add(nx);
                        q.add(ny);
                        answer[nx][ny] = ++count;
                        x = nx;
                        y = ny;
                    }
                }
            }
        }
        return !horizontal;
    }

    private void moveArrange() {
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j <= max; j++) {
                check[i][j] = true;
            }
        }
    }
}

public class Dev2_2_2022 {
    public static void main(String[] args) {
        Solution131 sol = new Solution131();
//        int[][] ans = sol.solution(4, true);
        int[][] ans = sol.solution(5, false);
        System.out.println(Arrays.deepToString(ans));
    }
}
import java.util.LinkedList;
import java.util.Queue;

class Solution29 {
    static int n;
    static int m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static void bfs(int i, int j) {
        Queue<Integer> q = new LinkedList<>();
        boolean[][] check = new boolean[n][m];
        int[][] dist = new int[n][m];
        q.add(i);
        q.add(j);
        check[i][j] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
//                    if (check[nx][ny] == false && board[nx][ny] == 1) {
//                        check[nx][ny] = true;
//                        dist[nx][ny] = dist[x][y] + 1;
//                        q.add(nx);
//                        q.add(ny);
//                        answer++;
//                    }
                }
            }
        }
    }

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        int answer = -1;
        n = board.length;
        m = board[0].length;
        bfs(aloc[0],aloc[1]);
        bfs(bloc[0],bloc[1]);

        return answer;
    }
}


public class KK7 {
    public static void main(String[] args) {
        Solution29 sol = new Solution29();
        int ans = 0;
        ans = sol.solution(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, new int[]{1, 0}, new int[]{1, 2});
        System.out.println(ans);
    }
}

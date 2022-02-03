//playtime = 12:53

import java.util.LinkedList;
import java.util.Queue;

class Solution89 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(0);
        int[][] visited = new int[n][m];
        visited[0][0] = 1;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] != 0) {
                    if (visited[nx][ny] == 0) {
                        q.add(nx);
                        q.add(ny);
                        visited[nx][ny] = visited[x][y] + 1;
                    }
                }
            }
        }
        answer = visited[n - 1][m - 1] == 0 ? -1 : visited[n - 1][m - 1];
        return answer;
    }
}

public class P1844 {
    public static void main(String[] args) {
        Solution89 sol = new Solution89();
        int ans = 0;
        ans = sol.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}});
        System.out.println(ans);
    }
}
package question.PGWinterIntern;

import java.util.LinkedList;
import java.util.Queue;

class SolutionWinterIntern3 {

    static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};

    public int solution(String[] input) {
        int n = input.length;
        int m = input[0].length();
        int[][] map = init(input, n, m);

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(0);
        boolean[][] check = new boolean[n][m];
        check[0][0] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 0 && !check[nx][ny]) {
                        map[nx][ny] = map[x][y] + 1;
                        check[nx][ny] = true;
                        q.add(nx);
                        q.add(ny);
                    }
                }
            }
        }

        return map[n - 1][m - 1];
    }

    private int[][] init(String[] input, int n, int m) {
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (input[i].charAt(j) == '.') {
                    map[i][j] = 0;
                }
                if (input[i].charAt(j) == 'X') {
                    map[i][j] = -1;
                }
            }
        }
        return map;
    }
}

public class WinterIntern3 {
    public static void main(String[] args) {
        SolutionWinterIntern3 sol = new SolutionWinterIntern3();
        int ans = sol.solution(new String[]{"..XXX", "..XXX", "...XX", "X....", "XXX.."}); //5
        System.out.println(ans);
    }
}
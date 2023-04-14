package question.pgWinterIntern;

import java.util.LinkedList;
import java.util.Queue;

class SolutionWinterIntern3 {

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public int solution(String[] input) {
        int n = input.length;
        int m = input[0].length();
        int[][][] map = init(input, n, m);

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(0);
        q.add(0);
        map[0][0][0] = 1;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            int dir = q.remove(); // 방향 정보
            for (int i : new int[]{7, 0, 1}) {
                int nDir = (dir + i) % 8;
                int nx = x + dx[nDir];
                int ny = y + dy[nDir];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny][nDir] == 0) {
                        map[nx][ny][nDir] = map[x][y][dir] + 1;
                        q.add(nx);
                        q.add(ny);
                        q.add(nDir);
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 8; i++) {
            if (map[n - 1][m - 1][i] > 0) {
                answer = Math.min(answer, map[n - 1][m - 1][i]);
            }
        }
        return answer;
    }

    private int[][][] init(String[] input, int n, int m) {
        int[][][] map = new int[n][m][8];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 8; k++) {
                    if (input[i].charAt(j) == '.') {
                        map[i][j][k] = 0;
                    }
                    if (input[i].charAt(j) == 'X') {
                        map[i][j][k] = -1;
                    }
                }
            }
        }
        return map;
    }
}

public class WinterIntern3 {
    public static void main(String[] args) {
        SolutionWinterIntern3 sol = new SolutionWinterIntern3();
//        int ans = sol.solution(new String[]{"..XXX", "..XXX", "...XX", "X....", "XXX.."}); //5
        int ans = sol.solution(new String[]{"..XXX..X", "XX...XX.", "X.XX.XX.", "X.XXX..X", "X.XXXXXX", "XX......"}); //23
        System.out.println(ans);
    }
}
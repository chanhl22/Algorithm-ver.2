/**
 * playtime = 27:19
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution154540 {
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    public int[] solution(String[] maps) {
        int[][] map = init(maps);
        int n = map.length;
        int m = map[0].length;
        boolean[][] isVisit = new boolean[n][m];

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != -1 && !isVisit[i][j]) {
                    answer.add(bfs(i, j, map, isVisit, n, m));
                }
            }
        }

        return convertListToArray(answer);
    }

    private int[] convertListToArray(List<Integer> answer) {
        if (answer.isEmpty()) {
            return new int[]{-1};
        }
        Collections.sort(answer);
        int[] ret = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            ret[i] = answer.get(i);
        }
        return ret;
    }

    private Integer bfs(int sx, int sy, int[][] map, boolean[][] isVisit, int n, int m) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sx);
        q.add(sy);
        isVisit[sx][sy] = true;

        int result = map[sx][sy];
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!isVisit[nx][ny] && map[nx][ny] != -1) {
                        q.add(nx);
                        q.add(ny);
                        isVisit[nx][ny] = true;
                        result += map[nx][ny];
                    }
                }
            }
        }
        return result;
    }

    private int[][] init(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'X') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = maps[i].charAt(j) - '0';
                }
            }
        }
        return map;
    }
}

public class P154540 {
    public static void main(String[] args) {
        Solution154540 sol = new Solution154540();
//        int[] ans = sol.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"});
        int[] ans = sol.solution(new String[]{"XXX","XXX","XXX"});
        System.out.println(Arrays.toString(ans));
    }
}
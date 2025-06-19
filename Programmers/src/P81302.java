/**
 * 거리두기 확인하기
 * playtime = 38m 27s
 */

import java.util.LinkedList;
import java.util.Queue;

public class P81302 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] a = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] ans = sol.solution(a);
        for (int i = 0; i < 5; i++) {
            System.out.print(ans[i]);
        }
    }

    static class Solution {

        private static final int n = 5;
        private static final int[] dx = {0, 0, -1, 1};
        private static final int[] dy = {-1, 1, 0, 0};

        public int[] solution(String[][] places) {
            int[] answer = new int[5];

            for (int i = 0; i < n; i++) {
                boolean solve = solve(places[i]);
                if (solve) {
                    answer[i] = 0;
                } else {
                    answer[i] = 1;
                }
            }

            return answer;
        }

        private boolean solve(String[] place) {
            char[][] map = createMap(place);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    char c = map[i][j];
                    if (c == 'P') {
                        if (bfs(i, j, map) == 0) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }

        private int bfs(int i, int j, char[][] map) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            q.offer(j);

            int[][] record = new int[n][n];
            record[i][j] = 0;

            boolean[][] visited = new boolean[n][n];
            visited[i][j] = true;

            while (!q.isEmpty()) {
                int x = q.remove();
                int y = q.remove();
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] != 'X' && !visited[nx][ny]) {
                        q.offer(nx);
                        q.offer(ny);
                        visited[nx][ny] = true;
                        record[nx][ny] = record[x][y] + 1;
                    }
                }
            }

            for (int i1 = 0; i1 < n; i1++) {
                for (int i2 = 0; i2 < n; i2++) {
                    if (record[i1][i2] > 0 && record[i1][i2] <= 2) {
                        if (map[i1][i2] == 'P') {
                            return 0;
                        }
                    }

                }
            }

            return 1;
        }


        private char[][] createMap(String[] place) {
            char[][] map = new char[n][n];
            for (int i = 0; i < n; i++) {
                map[i] = place[i].toCharArray();
            }
            return map;
        }
    }
}

//import java.util.LinkedList;
//import java.util.Queue;
//
//class Solution3 {
//    int[] dx = {0, 0, -1, 1};
//    int[] dy = {-1, 1, 0, 0};
//
//    public int bfs(char[][] a) {
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                if (a[i][j] != 'P') continue;
//                int[][] d = new int[5][5];
//                boolean[][] check = new boolean[5][5];
//                Queue<Integer> q = new LinkedList<>();
//                q.add(i);
//                q.add(j);
//                d[i][j] = 0;
//                check[i][j] = true;
//                while (!q.isEmpty()) {
//                    int x = q.remove();
//                    int y = q.remove();
//                    for (int k = 0; k < 4; k++) {
//                        int nx = x + dx[k];
//                        int ny = y + dy[k];
//                        if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
//                            if (check[nx][ny] == true) continue;
//                            if (a[nx][ny] != 'X') {
//                                d[nx][ny] = d[x][y] + 1;
//                                check[nx][ny] = true;
//                                q.add(nx);
//                                q.add(ny);
//                            }
//                        }
//                    }
//                }
//                for (int i2 = 0; i2 < 5; i2++) {
//                    for (int i3 = 0; i3 < 5; i3++) {
//                        if (d[i2][i3] <= 2 && d[i2][i3] > 0) {
//                            if (a[i2][i3] == 'P') {
//                                return 0;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return 1;
//    }
//
//    public int[] solution(String[][] places) {
//        int[] answer = new int[5];
//        for (int i = 0; i < 5; i++) {
//            char[][] a = new char[5][5];
//            for (int j = 0; j < 5; j++) {
//                for (int l = 0; l < 5; l++) {
//                    a[j][l] = places[i][j].charAt(l);
//                }
//            }
//            answer[i] = bfs(a);
//        }
//        return answer;
//    }
//}
//
//public class P81302 {
//    public static void main(String[] args) {
//        Solution3 sol = new Solution3();
//        String[][] a = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
//                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
//                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
//                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
//                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
//        int[] ans = sol.solution(a);
//        for (int i = 0; i < 5; i++) {
//            System.out.print(ans[i]);
//        }
//    }
//}

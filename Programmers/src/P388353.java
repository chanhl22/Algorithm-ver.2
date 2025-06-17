/**
 * 2025 프로그래머스 코드챌린지 1차 예선 > 지게차와 크레인
 * playtime = 58m 45s
 */

import java.util.LinkedList;
import java.util.Queue;

public class P388353 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] storage = {"AZWQY", "CAABX", "BBDDA", "ACACA"};
        String[] requests = {"A", "BB", "A"};

        int ans = 0;
        ans = sol.solution(storage, requests);
        System.out.println(ans);
    }

    static class Solution {

        private static String[][] map;
        private static int n;
        private static int m;
        private static final int[] dx = {0, 0, -1, 1};
        private static final int[] dy = {-1, 1, 0, 0};

        public int solution(String[] storage, String[] requests) {
            map = convertToMap(storage);
            n = map.length;
            m = map[0].length;

            for (int k = 0; k < requests.length; k++) {
                String request = requests[k];
                String removeString = Character.toString(request.charAt(0));
                if (request.length() == 1) {
                    sideRemove(removeString);
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (map[i][j].equals("-")) {
                                map[i][j] = "";
                            }
                        }
                    }
                } else {
                    allRemove(removeString);
                }
            }
            int answer = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!map[i][j].isEmpty()) {
                        answer++;
                    }
                }
            }

            return answer;
        }

        private void sideRemove(String removeString) {
            Queue<Integer> queue = new LinkedList<>();

            queue.add(0);
            queue.add(0);

            while (!queue.isEmpty()) {
                int x = queue.remove();
                int y = queue.remove();
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                        if (map[nx][ny].isEmpty()) {
                            queue.add(nx);
                            queue.add(ny);
                            map[nx][ny] = "-";
                        }
                        if (map[nx][ny].equals(removeString)) {
                            map[nx][ny] = "-";
                        }
                    }
                }
            }
        }

        private void allRemove(String removeString) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j].equals(removeString)) {
                        map[i][j] = "";
                    }
                }
            }
        }


        private String[][] convertToMap(String[] storage) {
            int n = storage.length + 2;
            int m = storage[0].length() + 2;

            String[][] map = new String[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i > 0 && j > 0 && i < n - 1 && j < m - 1) {
                        map[i][j] = storage[i - 1].charAt(j - 1) + "";
                    } else {
                        map[i][j] = "";
                    }
                }
            }

            return map;
        }
    }
}
/**
 * playtime = 07m56s
 */

public class P250125 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
//        ans = sol.solution(new String[][]{
//                {"blue", "red", "orange", "red"},
//                {"red", "red", "blue", "orange"},
//                {"blue", "orange", "red", "red"},
//                {"orange", "orange", "red", "blue"}
//        }, 1, 1);
        ans = sol.solution(new String[][]{
                {"yellow", "green", "blue"},
                {"blue", "green", "yellow"},
                {"yellow", "blue", "blue"}
        }, 0, 1);
        System.out.println(ans);
    }

    static class Solution {

        private static final int[] dx = {0, 0, -1, 1};
        private static final int[] dy = {-1, 1, 0, 0};

        public int solution(String[][] board, int x, int y) {
            int count = 0;
            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + x;
                int ny = dy[k] + y;
                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board.length)
                    if (board[nx][ny].equals(board[x][y])) {
                        count++;
                    }
            }
            return count;
        }
    }
}

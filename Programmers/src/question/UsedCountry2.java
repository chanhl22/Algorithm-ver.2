package question;

class Solution113 {
    static int n;
    static int m;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int result = 0;

    public int solution(int[][] board) {
        n = board.length;
        m = board[0].length;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                go(i, j, board[i][j], board, 1);
                visited[i][j] = false;
            }
        }
        int answer = result;
        return answer == 1 ? -1 : answer;
    }

    private void go(int sx, int sy, int value, int[][] board, int sum) {
        if (result < sum) {
            result = sum;
        }
        for (int i = 0; i < 4; i++) {
            int x = sx + dx[i];
            int y = sy + dy[i];
            if (x >= 0 && x < n && y >= 0 && y < m) {
                if (visited[x][y] == false && board[x][y] == value) {
                    visited[x][y] = true;
                    go(x, y, value, board, sum + 1);
                    visited[x][y] = false;
                }
            }
        }
    }
}


public class UsedCountry2 {
    public static void main(String[] args) {
        Solution113 sol = new Solution113();
        int ans = 0;
//        ans = sol.solution(new int[][]{{3, 2, 3, 2}, {2, 1, 1, 2}, {1, 1, 2, 1}, {4, 1, 1, 1}});
        ans = sol.solution(new int[][]{{4,2,3,2}, {2,1,2,4}, {1,2,3,1}, {4,1,4,3}});
        System.out.println(ans);
    }
}
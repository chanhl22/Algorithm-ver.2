/**
 * playtime = 59m12s
 */

public class P160585 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
//        ans = sol.solution(new String[]{"O.X", ".O.", "..X"});
//        ans = sol.solution(new String[]{"OOO", "...", "XXX"});
//        ans = sol.solution(new String[]{"OXO", "OXO", "XX."});
//        ans = sol.solution(new String[]{"OXO", "OXX", "OOX"});
        ans = sol.solution(new String[]{"OOO", "OXX", "OXX"}); //1
//        ans = sol.solution(new String[]{"OXO", "X.X", "XOX"});
        System.out.println(ans);
    }

    static class Solution {

        private static final int LEN = 3;

        public int solution(String[] board) {
            // 불가능한 경우
            // 1. X가 더 많은 경우
            int xCount = getCount(board, 'X');
            int oCount = getCount(board, 'O');
            if (xCount > oCount) {
                return 0;
            }

            // 2. O - X의 개수 차가 2 이상인 경우
            if (oCount - xCount >= 2) {
                return 0;
            }

            // 3. O가 이겼는데 O와 X의 개수가 같은 경우
            if (isWin(board, 'O')) {
                if (oCount == xCount) {
                    return 0;
                }
            }

            // 4. X가 이겼는데 O가 1개 더 많은 경우
            if (isWin(board, 'X')) {
                if (oCount - xCount == 1) {
                    return 0;
                }
            }
            return 1;
        }

        private int getCount(String[] board, char c) {
            int count = 0;
            for (int i = 0; i < LEN; i++) {
                for (int j = 0; j < LEN; j++) {
                    if (board[i].charAt(j) == c) {
                        count++;
                    }
                }
            }
            return count;
        }

        private boolean isWin(String[] board, char c) {
            for (int i = 0; i < LEN; i++) {
                if (board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c) {
                    return true;
                }
            }
            for (int i = 0; i < LEN; i++) {
                if (board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) {
                    return true;
                }
            }
            if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) {
                return true;
            }
            if (board[2].charAt(0) == c && board[1].charAt(1) == c && board[0].charAt(2) == c) {
                return true;
            }
            return false;
        }
    }
}

/**
 * playtime = 03:11:15
 *
class Solution160585 {
    private static final int LEN = 3;

    public int solution(String[] board) {
        char[][] map = initMap(board);

        int OCount = findCount(map, 'O');
        int XCount = findCount(map, 'X');

        if (!(OCount - XCount == 0 || OCount - XCount == 1)) {
            return 0;
        }

        boolean OWin = isWin(map, 'O');
        boolean XWin = isWin(map, 'X');

        if (OWin && XWin) {
            return 0;
        } else if (OWin) {
            if (OCount - XCount != 1) {
                return 0;
            }
        } else if (XWin) {
            if (OCount != XCount) {
                return 0;
            }
        }
        return 1;
    }

    private boolean isWin(char[][] map, char find) {
        boolean resultRow = false;
        boolean resultColumn = false;
        boolean resultCross1 = false;
        boolean resultCross2 = false;
        for (int i = 0; i < LEN; i++) {
            if (findFinishRow(map, i, find)) {
                resultRow = true;
                break;
            }
        }
        for (int i = 0; i < LEN; i++) {
            if (findFinishColumn(map, i, find)) {
                resultColumn = true;
                break;
            }
        }
        resultCross1 = findFinishCross1(map, find);
        resultCross2 = findFinishCross2(map, find);

        return resultRow || resultColumn || resultCross1 || resultCross2;
    }

    private int findCount(char[][] map, char find) {
        int count = 0;
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < LEN; j++) {
                if (map[i][j] == find) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean findFinishCross1(char[][] map, char find) {
        return map[0][0] == map[1][1] && map[1][1] == map[2][2] && map[0][0] == find;
    }

    private boolean findFinishCross2(char[][] map, char find) {
        return map[2][0] == map[1][1] && map[1][1] == map[0][2] && map[2][0] == find;
    }

    private boolean findFinishRow(char[][] map, int i, char find) {
        return map[i][0] == map[i][1] && map[i][1] == map[i][2] && map[i][0] == find;
    }

    private boolean findFinishColumn(char[][] map, int i, char find) {
        return map[0][i] == map[1][i] && map[1][i] == map[2][i] && map[0][i] == find;
    }

    private char[][] initMap(String[] board) {
        char[][] map = new char[LEN][LEN];
        for (int i = 0; i < LEN; i++) {
            map[i] = board[i].toCharArray();
        }
        return map;
    }
}

public class P160585 {
    public static void main(String[] args) {
        Solution160585 sol = new Solution160585();
        int ans = 0;
        //        ans = sol.solution(new String[]{"O.X", ".O.", "..X"});
        //        ans = sol.solution(new String[]{"OOO", "...", "XXX"});
        //        ans = sol.solution(new String[]{"OXO", "OXO", "XX."});
        //        ans = sol.solution(new String[]{"OXO", "OXX", "OOX"});
                ans = sol.solution(new String[]{"OOO", "OXX", "OXX"}); //1
//        ans = sol.solution(new String[]{"OXO", "X.X", "XOX"});
        System.out.println(ans);
    }
}
*/
/**
 * playtime = 02:10:00
 */

class Solution160585 {
    private static final int LEN = 3;

    public int solution(String[] board) {
        char[][] map = initMap(board);
        boolean[][] isVisit = initIsVisit(map);

        int sequence = 0;
        for (int i = 0; i < LEN * LEN; i++) {
            if (checkAllVisit(isVisit)) {
                break;
            }
            if (checkWrongSequence(map, isVisit, sequence % 2 == 0 ? 'O' : 'X')) {
                return 0;
            }
            sequence++;
        }

        if (hasTwoFinish(map)) {
            return 0;
        }
        return 1;
    }

    private boolean hasTwoFinish(char[][] map) {
        boolean checkO = false;
        boolean checkX = false;
        boolean tempO = false;
        boolean tempX = false;
        for (int i = 0; i < LEN; i++) {
            tempO = findFinish(map, i, 'O');
            tempX = findFinish(map, i, 'X');
            if (tempO) {
                checkO = true;
            }
            if (tempX) {
                checkX = true;
            }
        }
        tempO = findFinishCross(map, 'O');
        tempX = findFinishCross(map, 'X');
        if (tempO) {
            checkO = true;
        }
        if (tempX) {
            checkX = true;
        }
        if (checkO && checkX) {
            return true;
        }
        return false;
    }

    private boolean findFinishCross(char[][] map, char o) {
        if (map[0][0] == map[1][1] && map[1][1] == map[2][2] && map[0][0] == o) {
            return true;
        }
        return false;
    }

    private boolean findFinish(char[][] map, int i, char o) {
        if (map[i][0] == map[i][1] && map[i][1] == map[i][2] && map[i][0] == o) {
            return true;
        }
        if (map[0][i] == map[1][i] && map[1][i] == map[2][i] && map[0][i] == o) {
            return true;
        }
        return false;
    }

    private boolean checkAllVisit(boolean[][] isVisit) {
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < LEN; j++) {
                if (!isVisit[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkWrongSequence(char[][] map, boolean[][] isVisit, char findSequence) {
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < LEN; j++) {
                if (map[i][j] == findSequence && !isVisit[i][j]) {
                    isVisit[i][j] = true;
                    return false;
                }
            }
        }
        return true;
    }

    private char[][] initMap(String[] board) {
        char[][] map = new char[LEN][LEN];
        for (int i = 0; i < LEN; i++) {
            map[i] = board[i].toCharArray();
        }
        return map;
    }

    private boolean[][] initIsVisit(char[][] map) {
        boolean[][] check = new boolean[LEN][LEN];
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < LEN; j++) {
                if (map[i][j] == '.') {
                    check[i][j] = true;
                }
            }
        }
        return check;
    }
}

public class P160585 {
    public static void main(String[] args) {
        Solution160585 sol = new Solution160585();
        int ans = 0;
//        ans = sol.solution(new String[]{"O.X", ".O.", "..X"});
//        ans = sol.solution(new String[]{"OOO", "...", "XXX"});
//        ans = sol.solution(new String[]{"OXO", "OXO", "XX."});
        ans = sol.solution(new String[]{"OXO", "OXX", "OOX"});
        /**
         * oxo
         * oxx
         * oox
         */
        System.out.println(ans);
    }
}
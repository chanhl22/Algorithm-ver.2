package question;

import java.util.Arrays;

class Solution55 {
    public int[][] solution(int rows, int columns) {
        int[][] answer = new int[rows][columns];
        int index = 1;
        int x = 0;
        int y = 0;
        answer[x][y] = index;
        while (true) {
            if (answer[x][y] % 2 == 0) {
                x = (x + 1) % rows;
            } else {
                y = (y + 1) % columns;
            }
            index++;
            int temp = answer[x][y];
            answer[x][y] = index;
            if (index > 1 && answer[0][0] != 1 && answer[0][0] % 2 == 1) {
                answer[x][y] = temp;
                break;
            }
            boolean ok = true;
            for (int i = 0; i < answer.length; i++) {
                for (int j = 0; j < answer[0].length; j++) {
                    if (answer[i][j] == 0) {
                        ok = false;
                    }
                }
            }
            if (ok) {
                break;
            }
        }
        return answer;
    }
}


public class WO5 {
    public static void main(String[] args) {
        Solution55 sol = new Solution55();
        int[][] ans = sol.solution(3, 4);
        //int[][] ans = sol.solution(3, 3);
        System.out.println(Arrays.deepToString(ans));
    }
}
package question;

import java.util.Arrays;

class Solution132 {
    public int[] solution(int rows, int columns, int[][] lands) {
        int[] answer = {};
        int[][] all = new int[rows][columns];
        for (int i = 0; i < lands.length; i++) {
            all[lands[i][0] - 1][lands[i][1] - 1] = 1;
        }
        System.out.println(Arrays.deepToString(all));
        return answer;
    }
}

public class Dev3_2_2022 {
    public static void main(String[] args) {
        Solution132 sol = new Solution132();
        int[] ans = sol.solution(5, 6, new int[][]{{2, 2}, {2, 3}, {2, 4}, {3, 2}, {3, 5}, {4, 3}, {4, 4}});
        System.out.println(Arrays.toString(ans));
    }
}
package question;

import java.util.Arrays;

class Solution57 {
    public String[] solution(String[] grid, boolean clockwise) {
        int n = grid.length;
        String[] answer = new String[n];
        if (clockwise == true) {
            for (int i = 0; i < n; i++) {
                String temp = "";
                for (int j = 0; j < n; j++) {
                    if (i > j) {
                        continue;
                    }
                    if (grid[j].length() - 2 * (i + 1) < 0) {
                        temp += grid[j].substring(0, 1);
                    } else {
                        temp = grid[j].substring(grid[j].length() - 2 * (i + 1), grid[j].length() - 2 * i - 1) + temp;
                        temp = grid[j].substring(grid[j].length() - 2 * (i + 1) + 1, grid[j].length() - 2 * i) + temp;
                    }
                }
                answer[n - i - 1] = temp;
            }
        } else {
            for (int k = 0; k < 2; k++) {
                for (int i = 0; i < n; i++) {
                    String temp = "";
                    for (int j = 0; j < n; j++) {
                        if (i > j) {
                            continue;
                        }
                        if (grid[j].length() - 2 * (i + 1) < 0) {
                            temp += grid[j].substring(0, 1);
                        } else {
                            temp = grid[j].substring(grid[j].length() - 2 * (i + 1), grid[j].length() - 2 * i - 1) + temp;
                            temp = grid[j].substring(grid[j].length() - 2 * (i + 1) + 1, grid[j].length() - 2 * i) + temp;
                        }
                    }
                    answer[n - i - 1] = temp;
                }
            }
        }
        return answer;
    }
}


public class WO7 {
    public static void main(String[] args) {
        Solution57 sol = new Solution57();
        //String[] ans = sol.solution(new String[]{"1", "234", "56789"}, true);
        String[] ans = sol.solution(new String[]{"A", "MAN", "DRINK", "WATER11"}, false);
        System.out.println(Arrays.toString(ans));
    }
}
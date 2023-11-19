package question;

class SolutionSocar2023_2 {

    private final static int MAX_COLOR_COUNT = 11;

    public int solution(int n, int k, int[][] grid) {
        for (int len = n; len > 1; len--) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i + len - 1 >= n || j + len - 1 >= n) {
                        continue;
                    }
                    int minSwitchCount = findMinSwitchColor(i, j, i + len - 1, j + len - 1, grid, len * len);
                    if (minSwitchCount <= k) {
                        return len * len;
                    }
                }
            }
        }
        return 1;
    }

    private int findMinSwitchColor(int sx, int sy, int ex, int ey, int[][] grid, int totalCount) {
        int[] checkedColorCount = updateCheckedColorCount(sx, sy, ex, ey, grid);
        int max = 0;
        for (int i = 1; i < MAX_COLOR_COUNT; i++) {
            if (max < checkedColorCount[i]) {
                max = checkedColorCount[i];
            }
        }
        return totalCount - max;
    }

    private int[] updateCheckedColorCount(int sx, int sy, int ex, int ey, int[][] grid) {
        int[] checkCount = new int[MAX_COLOR_COUNT];
        for (int i = sx; i <= ex; i++) {
            for (int j = sy; j <= ey; j++) {
                checkCount[grid[i][j]]++;
            }
        }
        return checkCount;
    }
}

public class Socar2023_2 {
    public static void main(String[] args) {
        SolutionSocar2023_2 sol = new SolutionSocar2023_2();
//        int ans = sol.solution(4, 3, new int[][]{{1, 2, 2, 2}, {1, 2, 1, 1}, {1, 2, 2, 1}, {3, 2, 1, 1}}); // 9
//        int ans = sol.solution(3, 2, new int[][]{{1, 1, 1}, {1, 2, 2}, {1, 2, 4}}); // 4
//        int ans = sol.solution(2, 4, new int[][]{{1, 2}, {3, 4}}); // 4
//        int ans = sol.solution(2, 1, new int[][]{{1, 1}, {1, 4}}); // 4
        int ans = sol.solution(3, 4, new int[][]{{1, 1, 1}, {1, 2, 2}, {1, 2, 4}}); // 9
        System.out.println(ans);
    }
}
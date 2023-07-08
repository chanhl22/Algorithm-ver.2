package question.to2s;

import java.util.Arrays;

class SolutionT22023 {
    public int solution(int[][] relationships, int target, int limit) {
        int maxNumber = findMaxNumber(relationships);

        int[][] d = new int[maxNumber + 1][maxNumber + 1];
        for (int i = 0; i <= maxNumber; i++) {
            Arrays.fill(d[i], 1000000);
        }

        for (int[] relationship : relationships) {
            d[relationship[0]][relationship[1]] = 1;
            d[relationship[1]][relationship[0]] = 1;
        }

        for (int k = 1; k <= maxNumber; k++) {
            for (int i = 1; i <= maxNumber; i++) {
                for (int j = 1; j <= maxNumber; j++) {
                    if (i == j) continue;
                    if (d[i][k] + d[k][j] < d[i][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }

        int oldFriend = 0;
        int newFriend = 0;
        for (int i = 0; i <= maxNumber ; i++) {
            if (d[target][i] == 1) {
                oldFriend++;
            } else if (d[target][i] <= limit) {
                newFriend++;
            }
        }
        return (oldFriend * 5) + (newFriend * 10) + newFriend;
    }

    private int findMaxNumber(int[][] relationships) {
        int max = 0;
        for (int[] relationship : relationships) {
            for (int j = 0; j < 2; j++) {
                max = Math.max(max, relationship[j]);
            }
        }
        return max;
    }
}

public class T22023 {
    public static void main(String[] args) {
        SolutionT22023 sol = new SolutionT22023();
        int ans = 0;
        ans = sol.solution(new int[][]{{1, 2}, {2, 3}, {2, 6}, {3, 4}, {4, 5}}, 2, 3);
        System.out.println(ans);
    }
}
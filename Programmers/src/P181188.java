/**
 * playtime = 01:03:10
 */

import java.util.Arrays;

class Solution181188 {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        int answer = 1;

        int end = targets[0][1];
        for (int[] target : targets) {
            if (target[0] >= end) {
                answer++;
                end = target[1];
            }
        }
        return answer;
    }
}

public class P181188 {
    public static void main(String[] args) {
        Solution181188 sol = new Solution181188();
        int ans = 0;
//        ans = sol.solution(new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}});
//        ans = sol.solution(new int[][]{{4, 5}, {4, 6}, {7, 9}});
        ans = sol.solution(new int[][]{{2, 4}, {4, 6}, {6, 8}, {3, 10}});
        System.out.println(ans);
    }
}
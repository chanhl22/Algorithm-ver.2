/**
 * playtime = 09:57
 */

import java.util.Arrays;

class Solution161989 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] tile = new boolean[n];
        Arrays.fill(tile, true);
        for (int point : section) {
            tile[point - 1] = false;
        }

        for (int i = 0; i < n; i++) {
            if (!tile[i]) {
                for (int j = i; j < i + m; j++) {
                    if (j >= n) {
                        continue;
                    }
                    tile[j] = true;
                }
                answer++;
            }
        }

        return answer;
    }
}

public class P161989 {
    public static void main(String[] args) {
        Solution161989 sol = new Solution161989();
        int ans = 0;
//        ans = sol.solution(8, 4, new int[]{2, 3, 6});
        ans = sol.solution(8, 4, new int[]{6, 7, 8});
        System.out.println(ans);
    }
}
/**
 * playtime = 36:35
 */

import java.util.Arrays;

class Solution154538 {
    private static final int MAX = 1000001;

    public int solution(int x, int y, int n) {
        int[] num = new int[MAX];
        Arrays.fill(num, -1);
        num[x] = 0;

        for (int i = x; i <= y; i++) {
            if (num[i] != -1) {
                if (i + n < MAX) {
                    if (num[i + n] == -1) {
                        num[i + n] = num[i] + 1;
                    } else {
                        num[i + n] = Math.min(num[i] + 1, num[i + n]);
                    }
                }
                if (i * 2 < MAX) {
                    if (num[i * 2] == -1) {
                        num[i * 2] = num[i] + 1;
                    } else {
                        num[i * 2] = Math.min(num[i] + 1, num[i * 2]);
                    }
                }
                if (i * 3 < MAX) {
                    if (num[i * 3] == -1) {
                        num[i * 3] = num[i] + 1;
                    } else {
                        num[i * 3] = Math.min(num[i] + 1, num[i * 3]);
                    }
                }
            }
        }

        return num[y];
    }
}

public class P154538 {
    public static void main(String[] args) {
        Solution154538 sol = new Solution154538();
        int ans = 0;
        ans = sol.solution(10, 1000000, 5);
        System.out.println(ans);
    }
}
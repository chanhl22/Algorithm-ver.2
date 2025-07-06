/**
 * 숫자 변환하기
 * playtime = 33m 46s
 * 풀이횟수 = 2
 */

import java.util.Arrays;

public class P154538 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
//        ans = sol.solution(10, 1000000, 5);
        ans = sol.solution(2, 10, 6); // 2
        System.out.println(ans);
    }

    static class Solution {

        private final static int EMPTY = -1;
        private final static int MAX = 1000001;

        public int solution(int x, int y, int n) {
            int[] dp = new int[MAX];
            Arrays.fill(dp, EMPTY);
            dp[x] = 0;

            for (int i = x; i <= y; i++) {
                if (dp[i] == EMPTY) {
                    continue;
                }

                int case1 = i + n;
                if (case1 < MAX) {
                    if (dp[case1] == EMPTY) {
                        dp[case1] = dp[i] + 1;
                    } else {
                        dp[case1] = Math.min(dp[i] + 1, dp[case1]);
                    }
                }

                int case2 = i * 2;
                if (case2 < MAX) {
                    if (dp[case2] == EMPTY) {
                        dp[case2] = dp[i] + 1;
                    } else {
                        dp[case2] = Math.min(dp[i] + 1, dp[case2]);
                    }
                }

                int case3 = i * 3;
                if (case3 < MAX) {
                    if (dp[case3] == EMPTY) {
                        dp[case3] = dp[i] + 1;
                    } else {
                        dp[case3] = Math.min(dp[i] + 1, dp[case3]);
                    }
                }
            }

            return dp[y];
        }
    }
}

//import java.util.Arrays;
//
//class Solution154538 {
//    private static final int MAX = 1000001;
//
//    public int solution(int x, int y, int n) {
//        int[] num = new int[MAX];
//        Arrays.fill(num, -1);
//        num[x] = 0;
//
//        for (int i = x; i <= y; i++) {
//            if (num[i] != -1) {
//                if (i + n < MAX) {
//                    if (num[i + n] == -1) {
//                        num[i + n] = num[i] + 1;
//                    } else {
//                        num[i + n] = Math.min(num[i] + 1, num[i + n]);
//                    }
//                }
//                if (i * 2 < MAX) {
//                    if (num[i * 2] == -1) {
//                        num[i * 2] = num[i] + 1;
//                    } else {
//                        num[i * 2] = Math.min(num[i] + 1, num[i * 2]);
//                    }
//                }
//                if (i * 3 < MAX) {
//                    if (num[i * 3] == -1) {
//                        num[i * 3] = num[i] + 1;
//                    } else {
//                        num[i * 3] = Math.min(num[i] + 1, num[i * 3]);
//                    }
//                }
//            }
//        }
//
//        return num[y];
//    }
//}
//
//public class P154538 {
//    public static void main(String[] args) {
//        Solution154538 sol = new Solution154538();
//        int ans = 0;
//        ans = sol.solution(10, 1000000, 5);
//        System.out.println(ans);
//    }
//}
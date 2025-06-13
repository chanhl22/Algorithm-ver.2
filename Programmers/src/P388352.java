/**
 * 2025 프로그래머스 코드챌린지 1차 예선 > 비밀 해독 코드
 * playtime = 40m 44s
 */

import java.util.ArrayList;

public class P388352 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int n = 10;
        int[][] q = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {3, 7, 8, 9, 10},
                {2, 5, 7, 9, 10},
                {3, 4, 5, 6, 7}
        };
        int[] ans = {2, 3, 4, 3, 3};

        int result = 0;
        result = sol.solution(n, q, ans);
        System.out.println(result);
    }

    static class Solution {
        
        public static int N;
        public static int[][] Q;
        public static int[] ANS;
        public static int RESULT;
        
        public int solution(int n, int[][] q, int[] ans) {
            //O(nC5*M) = 142,506 * 10 = 백만 좀 넘네? -> BF 가능
            N = n;
            Q = q;
            ANS = ans;

            ArrayList<Integer> list = new ArrayList<>();
            go(1, 0, list);

            return RESULT;
        }

        private void go(int index, int count, ArrayList<Integer> list) {
            if (count == 5) {
                if (check(list)) {
                    RESULT++;
                }
                return;
            }

            for (int i = index; i <= N; i++) {
                list.add(i);
                go(i + 1, count + 1, list);
                list.remove(list.size() - 1);
            }
        }

        private boolean check(ArrayList<Integer> list) {
            boolean result = true;
            for (int i = 0; i < Q.length; i++) {
                int count = 0;
                for (int j = 0; j < 5; j++) {
                    if (list.contains(Q[i][j])) {
                        count++;
                    }
                }
                if (count != ANS[i]) {
                    return false;
                }
            }
            return result;
        }
    }

}
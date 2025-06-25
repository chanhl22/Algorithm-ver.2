/**
 * 월간 코드 챌린지 시즌1 > 쿼드압축 후 개수 세기
 * playtime = 29m 03s
 */

import java.util.Arrays;

public class P68936 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] arr = {
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        };
        int[] ans = sol.solution(arr);
        System.out.println(Arrays.toString(ans));
    }

    static class Solution {

        public int[] answer;

        public int[] solution(int[][] arr) {
            int len = arr.length;
            answer = new int[2];

            go(len, 0, 0, arr);

            return answer;
        }

        private void go(int len, int x, int y, int[][] arr) {
            if (check(arr, x, y, len)) {
                if (arr[x][y] == 1) {
                    answer[1]++;
                } else {
                    answer[0]++;
                }
                return;
            }

            go(len / 2, x, y, arr);
            go(len / 2, x, y + len / 2, arr);
            go(len / 2, x + len / 2, y, arr);
            go(len / 2, x + len / 2, y + len / 2, arr);
        }

        private boolean check(int[][] arr, int x, int y, int len) {
            int standard = -1;
            for (int i = x; i < x + len; i++) {
                for (int j = y; j < y + len; j++) {
                    if (standard == -1) {
                        standard = arr[i][j];
                    } else {
                        if (standard != arr[i][j]) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
}
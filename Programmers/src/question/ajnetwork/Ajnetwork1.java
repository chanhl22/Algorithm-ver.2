package question.ajnetwork;

/**
 * 거울처럼 배열을 이동시키는 문제
 * 1 0
 * 0 1
 * 위 배열을 1번 (k번) 움직인다는 것은
 * 1 0 0 1
 * 0 1 1 0
 * 로 오른쪽으로 거울처럼 복사하고
 * 1 0 0 1
 * 0 1 1 0
 * 0 1 1 0
 * 1 0 0 1
 * 처럼 아래로 복사함.
 */

public class Ajnetwork1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[][] ans = sol.solution(new int[][]{{1, 0}, {0, 1}}, 2);
        int[][] ans = sol.solution(new int[][]{{1, 0, 0}, {0, 1, 1}, {1,0,1}}, 1);
        System.out.println(ans);
    }

    static class Solution {
        public int[][] solution(int[][] square, int k) {
            // 확장 len
            int n = square.length;
            int len = square.length * (int) Math.pow(2, k);
            int[][] answer = new int[len][len];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    answer[i][j] = square[i][j];
                }
            }

            //이걸 반복문으로
            for (int count = 0; count < k; count++) {
                int tempLen = square.length * (int) Math.pow(2, count);
                for (int i = 0; i < tempLen; i++) {
                    for (int j = 0; j < tempLen; j++) {
                        int value = answer[i][j];
                        int updatePoint = tempLen * 2;
                        answer[updatePoint - 1 - i][j] = value;
                        answer[updatePoint - 1 - i][updatePoint - 1 - j] = value;
                        answer[i][updatePoint - 1 - j] = value;
                    }
                }
            }

            return answer;
        }
    }
}

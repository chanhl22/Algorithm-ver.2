/**
 * 당구 연습
 * playtime = 1h 48m 41s
 */

import java.util.Arrays;

public class P169198 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(
                Arrays.toString(
                        sol.solution(10, 10, 3, 7, new int[][]{{7, 7}, {2, 7}, {7, 3}})
                )); //{52, 37, 116}

//        System.out.println(
//                Arrays.toString(
//                        sol.solution(10, 10, 3, 7, new int[][]{{7, 3}})
//                )); //{116}

//        System.out.println(
//                Arrays.toString(
//                        sol.solution(10, 10, 3, 7, new int[][]{{2, 7}})
//                )); //{37}
    }

    static class Solution {
        public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
            int[] answer = new int[balls.length];

            for (int i = 0; i < balls.length; i++) {
                int minDistanceSquared = Integer.MAX_VALUE;
                int endX = balls[i][0];
                int endY = balls[i][1];

                //상
                if (!(endX == startX && endY >= startY)) {
                    int moveX = endX;
                    int moveY = n + (n - endY);
                    int distanceSquared = calculateDistanceSquared(startX, startY, moveX, moveY);
                    minDistanceSquared = Math.min(minDistanceSquared, distanceSquared);
                }

                //하
                if (!(endX == startX && endY <= startY)) {
                    int moveX = endX;
                    int moveY = endY * -1;
                    int distanceSquared = calculateDistanceSquared(startX, startY, moveX, moveY);
                    minDistanceSquared = Math.min(minDistanceSquared, distanceSquared);
                }

                //좌
                if (!(endY == startY && endX <= startX)) {
                    int moveX = endX * -1;
                    int moveY = endY;
                    int distanceSquared = calculateDistanceSquared(startX, startY, moveX, moveY);
                    minDistanceSquared = Math.min(minDistanceSquared, distanceSquared);
                }

                //우
                if (!(endY == startY && endX >= startX)) {
                    int moveX = m + (m - endX);
                    int moveY = endY;
                    int distanceSquared = calculateDistanceSquared(startX, startY, moveX, moveY);
                    minDistanceSquared = Math.min(minDistanceSquared, distanceSquared);
                }

                answer[i] = minDistanceSquared;
            }
            return answer;
        }

        private int calculateDistanceSquared(int sx, int sy, int ex, int ey) {
            return (sx - ex) * (sx - ex) + (sy - ey) * (sy - ey);
        }
    }
}
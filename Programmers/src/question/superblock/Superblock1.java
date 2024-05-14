package question.superblock;

import java.util.Arrays;
import java.util.Comparator;

public class Superblock1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(
                Arrays.toString(
                        sol.solution(new int[][]{{0, 2, 1, 3}, {1, 2, 2, 5}, {3, 3, 4, 4}, {4, 1, 6, 3}, {1, 6, 5, 7}, {5, 5, 7, 6}, {5, 8, 6, 10}})
                )
        );
    }

    static class Square {
        int x1, y1, x2, y2, idx;

        public Square(int x1, int y1, int x2, int y2, int idx) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.idx = idx;
        }
    }

    static class Solution {

        private static final int NM = 100001;
        private static final Square[] SQUARES = new Square[NM];
        private static int N;
        private static final int[] HIGH = new int[1000001];


        public String[] solution(int[][] rectangles) {
            input(rectangles);

            applyGravity();
            for (int i = 1; i <= N; i++) {
                int temp = SQUARES[i].x1;
                SQUARES[i].x1 = SQUARES[i].y1;
                SQUARES[i].y1 = temp;
                temp = SQUARES[i].x2;
                SQUARES[i].x2 = SQUARES[i].y2;
                SQUARES[i].y2 = temp;
            }
            applyGravity();
            for (int i = 1; i <= N; i++) {
                int temp = SQUARES[i].x1;
                SQUARES[i].x1 = SQUARES[i].y1;
                SQUARES[i].y1 = temp;
                temp = SQUARES[i].x2;
                SQUARES[i].x2 = SQUARES[i].y2;
                SQUARES[i].y2 = temp;
            }
            Arrays.sort(SQUARES, 1, N + 1, Comparator.comparingInt(square -> square.idx));

            return getResult();
        }

        private void input(int[][] rectangles) {
            N = rectangles.length;
            for (int i = 1; i <= N; i++) {
                int x1 = rectangles[i - 1][0], y1 = rectangles[i - 1][1], x2 = rectangles[i - 1][2], y2 = rectangles[i - 1][3];
                SQUARES[i] = new Square(x1, y1, x2, y2, i);
            }
        }

        public static void applyGravity() {
            Arrays.fill(HIGH, 0);
            Arrays.sort(SQUARES, 1, N + 1, Comparator.comparingInt(square -> square.y1));
            for (int i = 1; i <= N; i++) {
                Square square = SQUARES[i];
                int maxH = 0;
                for (int x = square.x1; x < square.x2; x++) {
                    maxH = Math.max(maxH, HIGH[x]);
                }
                for (int x = square.x1; x < square.x2; x++) {
                    HIGH[x] = maxH + square.y2 - square.y1;
                }
                square.y2 = maxH + square.y2 - square.y1;
                square.y1 = maxH;
            }
        }

        private String[] getResult() {
            String[] result = new String[N];
            for (int i = 1; i <= N; i++) {
                result[i - 1] = SQUARES[i].x1 + " " + SQUARES[i].y1 + " " + SQUARES[i].x2 + " " + SQUARES[i].y2;
            }
            return result;
        }
    }
}
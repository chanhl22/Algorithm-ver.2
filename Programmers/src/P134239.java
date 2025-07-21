/**
 * playtime = 37m 53s
 */

import java.util.ArrayList;
import java.util.Arrays;

public class P134239 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        double[] ans = sol.solution(5, new int[][]{{0, 0}, {0, -1}, {2, -3}, {3, -3}});
        System.out.println(Arrays.toString(ans));
    }

    static class Solution {

        private final ArrayList<Integer> coordinate = new ArrayList<>();
        private final ArrayList<Double> area = new ArrayList<>();

        public double[] solution(int k, int[][] ranges) {
            int count = calculateCoordinate(k);
            calculateArea();

            double[] answer = new double[ranges.length];
            int start = 0;
            int end = 0;
            for (int i = 0; i < ranges.length; i++) {
                start = ranges[i][0];
                end = count + ranges[i][1];

                if (start > end) {
                    answer[i] = -1.0;
                    continue;
                }

                double sum = 0;
                for (int j = start; j < end; j++) {
                    sum += area.get(j);
                }
                answer[i] = sum;
            }

            return answer;
        }

        private int calculateCoordinate(int k) {
            int count = 0;

            coordinate.add(0);
            coordinate.add(k);

            while (k > 1) {
                if (k % 2 == 0) {
                    k = k / 2;
                } else {
                    k = k * 3 + 1;
                }

                count++;

                coordinate.add(count);
                coordinate.add(k);
            }
            return count;
        }

        private void calculateArea() {
            for (int i = 0; i < coordinate.size() - 2; i += 2) {
                int sx = coordinate.get(i);
                int sy = coordinate.get(i + 1);
                int ex = coordinate.get(i + 2);
                int ey = coordinate.get(i + 3);

                int width = ex - sx;
                int length = 0;
                if (ey > sy) {
                    length = ey - sy;
                } else {
                    length = sy - ey;
                }

                double area1 = (double) (width * length) / 2;
                double area2 = Math.min(sy, ey);

                area.add(area1 + area2);
            }

        }
    }
}
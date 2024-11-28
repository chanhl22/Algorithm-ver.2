/**
 * playtime = 1h 29m 13s
 */

import java.util.Arrays;
import java.util.HashMap;

public class P152996 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        long ans = 0;
        ans = sol.solution(new int[]{100, 180, 360, 100, 270});
        System.out.println(ans);
    }

    static class Solution {
        public long solution(int[] weights) {
            long answer = 0;
            Arrays.sort(weights);

            HashMap<Integer, Long> sameWeightCountMap = new HashMap<>();
            for (int weight : weights) {
                sameWeightCountMap.put(weight, sameWeightCountMap.getOrDefault(weight, 0L) + 1);
            }

            for (int weight : sameWeightCountMap.keySet()) {
                long count = sameWeightCountMap.get(weight);
                if (count > 1) {
                    answer += (count * (count - 1)) / 2;
                }
            }

            HashMap<Double, Long> weightMap = new HashMap<>();

            for (int weight : weights) {
                int[] ratios = {2, 3, 4};
                for (int ratio1 : ratios) {
                    for (int ratio2 : ratios) {
                        if (ratio1 < ratio2) {
                            // ratio1, ratio2 값
                            // 2 3
                            // 2 4
                            // 3 4

                            // weight * ratio2, (weight * ratio2) / ratio1 결과값
                            // 100 -> 300, 150 / 400, 200 / 400, 133
                            // 100 -> 300, 150 / 400, 200 / 400, 133
                            // 180 -> 540, 270 / 720, 360 / 720, 240
                            // 270 -> 810, 405 / 1080, 540 / 1080, 360
                            // 360 ->

                            double findWeight = (double) (weight * ratio2) / ratio1;
                            weightMap.put(findWeight, weightMap.getOrDefault(findWeight, 0L) + 1);
                        }
                    }
                }
                answer += weightMap.getOrDefault((double) weight, 0L);
            }

            return answer;
        }
    }
}
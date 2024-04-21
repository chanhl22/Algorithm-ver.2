/**
 * [PCCP 기출문제 1번] 붕대감기
 * playtime = 40m 31s
 */

import java.util.HashMap;

public class P250137 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
//        ans = sol.solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}}); //5
//        ans = sol.solution(new int[]{1, 1, 1}, 5, new int[][]{{1, 2}, {3, 2}}); //3
//        ans = sol.solution(new int[]{1, 1, 1}, 5, new int[][]{{1, 2}, {2, 3}}); //-1
        ans = sol.solution(new int[]{2, 4, 4}, 100, new int[][]{{1, 96}, {18, 1}}); //99
        System.out.println(ans);
    }

    static class Solution {
        public int solution(int[] bandage, int health, int[][] attacks) {
            int max = health;
            // 총 시간
            int totalTime = findTotalTime(attacks);

            HashMap<Integer, Integer> attackMap = getAttackMap(attacks);

            int count = 0;
            for (int time = 1; time <= totalTime; time++) {
                Integer attack = attackMap.get(time);
                if (attack != null) {
                    health -= attack;
                    count = 0;
                } else {
                    count++;
                    if (count == bandage[0]) {
                        count = 0;
                        health += bandage[1] + bandage[2];
                    } else {
                        health += bandage[1];
                    }
                    if (health > max) {
                        health = max;
                    }
                }
                if (health <= 0) {
                    return -1;
                }
            }

            return health;
        }

        private HashMap<Integer, Integer> getAttackMap(int[][] attacks) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int[] attack : attacks) {
                map.put(attack[0], attack[1]);
            }
            return map;
        }

        private int findTotalTime(int[][] attacks) {
            int len = attacks.length;
            return attacks[len - 1][0];
        }
    }
}
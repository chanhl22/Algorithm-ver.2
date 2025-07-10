/**
 * 할인 행
 * playtime = 20m 16s
 */

import java.util.HashMap;

public class P131127 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
//        ans = sol.solution(
//                new String[]{"banana", "apple", "rice", "pork", "pot"},
//                new int[]{3, 2, 2, 2, 1},
//                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}
//        );
        ans = sol.solution(
                new String[]{"apple"},
                new int[]{10},
                new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}
        );
        System.out.println(ans);
    }

    static class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;

            for (int date = 0; date < discount.length; date++) {
                if (check(date, want, number, discount)) {
                    answer++;
                }
            }

            return answer;
        }

        private boolean check(int date, String[] want, int[] number, String[] discount) {
            HashMap<String, Integer> wantMap = new HashMap<>();
            for (int i = 0; i < want.length; i++) {
                wantMap.put(want[i], 0);
            }

            for (int i = date; i < date + 10; i++) {
                if (i == discount.length) {
                    break;
                }

                if (wantMap.containsKey(discount[i])) {
                    wantMap.put(discount[i], wantMap.get(discount[i]) + 1);
                }
            }

            for (int i = 0; i < want.length; i++) {
                if (number[i] != wantMap.get(want[i])) {
                    return false;
                }
            }

            return true;
        }
    }
}
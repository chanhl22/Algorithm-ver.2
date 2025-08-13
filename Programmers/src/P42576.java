/**
 * playtime = 8m 41s
 */

import java.util.HashMap;

public class P42576 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String ans = sol.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
        System.out.println(ans);
    }

    static class Solution {
        public String solution(String[] participant, String[] completion) {
            HashMap<String, Integer> peopleMap = new HashMap<>();

            for (String s : participant) {
                peopleMap.put(s, peopleMap.getOrDefault(s, 0) + 1);
            }

            for (String s : completion) {
                peopleMap.compute(s, (k, count) -> count - 1);
            }

            for (String s : participant) {
                if (peopleMap.get(s) == 1) {
                    return s;
                }
            }

            return "";
        }
    }
}
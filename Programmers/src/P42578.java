/**
 * playtime = 45m 52s
 * 풀이횟수 = 2
 */

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class P42578 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
//        ans = sol.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
        ans = sol.solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}});
        System.out.println(ans);
    }

    static class Solution {
        public int solution(String[][] clothes) {
            Map<String, Long> map = Arrays.stream(clothes)
                    .collect(Collectors.groupingBy(c -> c[1], Collectors.counting()));

            int result = 1;
            for (String s : map.keySet()) {
               result *= map.get(s) + 1;
            }

            return result - 1;
        }
    }
}

/**
import java.util.HashMap;

class Solution32 {
    public int solution(String[][] clothes) {
        int answer = 1;
        int n = clothes.length;
        HashMap<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            if (map.containsKey(clothes[i][1])) {
//                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
//            } else {
//                map.put(clothes[i][1], 1);
//            }
//        }
        for (int i = 0; i < n; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        for (Integer value : map.values()) {
            answer *= value + 1;
        }
        return answer - 1;
    }
}

public class P42578 {
    public static void main(String[] args) {
        Solution32 sol = new Solution32();
        int ans = 0;
        //ans = sol.solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}});
        ans = sol.solution(new String[][]{{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}});
        System.out.println(ans);
    }
}
*/
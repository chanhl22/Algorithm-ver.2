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

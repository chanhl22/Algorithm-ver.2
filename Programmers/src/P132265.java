/**
 * playtime = 39:01
 */

import java.util.HashMap;
import java.util.HashSet;

class Solution132265 {
    public int solution(int[] topping) {
        int answer = 0;

        HashMap<Integer, Integer> older = new HashMap<>();
        HashSet<Integer> younger = new HashSet<>();

        for (int i = 0; i < topping.length; i++) {
            older.put(topping[i], older.getOrDefault(topping[i], 0) + 1);
        }

        for (int i = 0; i < topping.length; i++) {
            younger.add(topping[i]);
            older.put(topping[i], older.get(topping[i]) - 1);
            if (older.get(topping[i]) == 0) {
                older.remove(topping[i]);
            }

            if (older.size() == younger.size()) {
                answer++;
            }
        }

        return answer;
    }
}

public class P132265 {
    public static void main(String[] args) {
        Solution132265 sol = new Solution132265();
        int ans = 0;
        ans = sol.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2});
        System.out.println(ans);
    }
}
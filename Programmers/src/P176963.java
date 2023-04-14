/**
 * playtime = 08:20
 */

import java.util.Arrays;
import java.util.HashMap;

class Solution176963 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        HashMap<String, Integer> map = new HashMap<>();
        init(map, name, yearning);

        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                String member = photo[i][j];
                Integer point = map.get(member);
                sum += point == null ? 0 : point;
            }
            answer[i] = sum;
        }

        return answer;
    }

    public static void init(HashMap<String, Integer> map, String[] name, int[] yearning) {
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
    }
}

public class P176963 {
    public static void main(String[] args) {
        Solution176963 sol = new Solution176963();
        int[] ans = sol.solution(
                new String[]{"may", "kein", "kain", "radi"},
                new int[]{5, 10, 1, 3},
                new String[][]{{"may", "kein", "kain", "radi"},
                        {"may", "kein", "brin", "deny"},
                        {"kon", "kain", "may", "coni"}});
        System.out.println(Arrays.toString(ans));
    }
}


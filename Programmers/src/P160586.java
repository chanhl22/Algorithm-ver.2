/**
 * playtime = 15m
 */

import java.util.Arrays;

class Solution160586 {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                char temp = targets[i].charAt(j);
                int min = findMin(keymap, temp);
                if (min == -1) {
                    sum = -1;
                    break;
                }
                sum += min;
            }
            answer[i] = sum;
        }
        return answer;
    }

    private int findMin(String[] keymap, char temp) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                if (keymap[i].charAt(j) == temp) {
                    min = Math.min(min, j + 1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}

public class P160586 {
    public static void main(String[] args) {
        Solution160586 sol = new Solution160586();
        int[] ans = sol.solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD","AABB"});
        System.out.println(Arrays.toString(ans));
    }
}

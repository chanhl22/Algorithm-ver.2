/**
 * playtime = 10m 58s
 */

import java.util.Arrays;
import java.util.TreeSet;

public class P42628 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] ans = sol.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
        System.out.println(Arrays.toString(ans));
    }

    static class Solution {
        public int[] solution(String[] operations) {
            TreeSet<Integer> heap = new TreeSet<>();

            for (int i = 0; i < operations.length; i++) {
                String[] split = operations[i].split(" ");
                if (split[0].equals("I")) {
                    heap.add(Integer.parseInt(split[1]));
                } else {
                    if (heap.isEmpty()) {
                        continue;
                    }

                    if (split[1].equals("1")) {
                        heap.pollLast();
                    } else {
                        heap.pollFirst();
                    }
                }
            }

            if (heap.isEmpty()) {
                return new int[]{0, 0};
            }

            return new int[]{heap.last(), heap.first()};
        }
    }
}
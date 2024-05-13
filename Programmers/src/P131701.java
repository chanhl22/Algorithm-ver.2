/**
 * playtime = 30m 59s
 */

import java.util.HashSet;

public class P131701 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
        ans = sol.solution(new int[]{7, 9, 1, 1, 4});
        System.out.println(ans);
    }

    static class Solution {
        public int solution(int[] elements) {
            int length = elements.length;
            int[] doubleElements = makeDoubleElements(elements, length);

            HashSet<Integer> set = new HashSet<>();

            for (int index = 0; index < length; index++) {
                int sum = 0;
                for (int i = 0; i < length; i++) {
                    sum += doubleElements[index + i];
                    set.add(sum);
                }
            }
            return set.size();
        }

        private int[] makeDoubleElements(int[] elements, int length) {
            int[] doubleElements = new int[length * 2];
            for (int i = 0; i < length; i++) {
                doubleElements[i] = elements[i];
                doubleElements[i + length] = elements[i];
            }
            return doubleElements;
        }
    }
}

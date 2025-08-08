/**
 * playtime = 23m 01s
 */

import java.util.Arrays;
import java.util.Collections;

public class P135808 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
        ans = sol.solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1});
        System.out.println(ans);
    }

    static class Solution {
        public int solution(int k, int m, int[] score) {
            Integer[] boxedArray = Arrays.stream(score).boxed().toArray(Integer[]::new);
            Arrays.sort(boxedArray, Collections.reverseOrder());
            score = Arrays.stream(boxedArray).mapToInt(Integer::intValue).toArray();

            int answer = 0;

            for (int i = 0; i < score.length; i += m) {
                if (i + m - 1 < score.length) {
                    answer += score[i + m - 1] * m;
                }
            }

            return answer;
        }
    }
}


/// / 16:42
//
//import java.util.Arrays;
//
//class Solution135808 {
//    public int solution(int k, int m, int[] score) {
//        int length = score.length;
//        Arrays.sort(score);
//        int[] temp = new int[length];
//        for (int i = length - 1, j = 0; i >= 0; i--, j++) {
//            temp[j] = score[i];
//        }
//
//        int answer = 0;
//        for (int i = 0; i < length; i += m) {
//            if (i + (m - 1) < length) {
//                answer += temp[i + (m - 1)] * m;
//            }
//        }
//        return answer;
//    }
//}
//
//public class P135808 {
//    public static void main(String[] args) {
//        Solution135808 sol = new Solution135808();
//        int ans = 0;
//        ans = sol.solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1});
//        System.out.println(ans);
//    }
//}
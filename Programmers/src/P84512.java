/**
 * 모음사전
 * playtime = 16m 19s
 */

import java.util.List;

public class P84512 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
//        ans = sol.solution("AAAAE");
        ans = sol.solution("AAAE");
        System.out.println(ans);
    }

    static class Solution {

        private static int COUNT = -1;
        private static String FINISH;
        private static List<String> ALPHABET = List.of("A", "E", "I", "O", "U");
        private static int ANSWER;

        public int solution(String word) {
            FINISH = word;

            go(0, "");

            return ANSWER;
        }

        private void go(int index, String str) {
            COUNT++;

            if (str.equals(FINISH)) {
                ANSWER = COUNT;
            }

            if (index == 5) {
                return;
            }

            for (int i = 0; i < ALPHABET.size(); i++) {
                go(index + 1, str + ALPHABET.get(i));
            }
        }
    }
}
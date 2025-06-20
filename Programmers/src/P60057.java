/**
 * 2020 KAKAO BLIND RECRUITMENT > 문자열 압축
 * playtime = 1s 13m 49s
 */

import java.util.ArrayList;
import java.util.List;

public class P60057 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
//        ans = sol.solution("aabbaccc"); //7
//        ans = sol.solution("abcabcdede"); //8
        ans = sol.solution("a"); //1
        System.out.println(ans);
    }

    static class Solution {
        public int solution(String s) {
            int totalLen = s.length() / 2;

            int answer = 1;

            for (int count = 1; count <= totalLen; count++) {
                int result = split(count, s);
                if (answer == 1 || answer > result) {
                    answer = result;
                }
            }

            return answer;
        }

        private int split(int count, String s) {
            StringBuilder sb = new StringBuilder();

            List<String> storage = new ArrayList<>();
            for (int i = 0; i < s.length(); i += count) {
                int end = Math.min(i + count, s.length());
                storage.add(s.substring(i, end));
            }

            int curInt = 1;
            for (int i = 0; i < storage.size() - 1; i++) {
                String curString = storage.get(i);
                String nextString = storage.get(i + 1);
                if (curString.equals(nextString)) {
                    curInt++;

                    if (i == storage.size() - 2) {
                        sb.append(curInt);
                        sb.append(curString);
                    }

                } else {
                    if (curInt != 1) {
                        sb.append(curInt);
                    }
                    sb.append(curString);

                    if (i == storage.size() - 2) {
                        sb.append(nextString);
                    }

                    curInt = 1;
                }

            }

            return sb.length();
        }
    }
}
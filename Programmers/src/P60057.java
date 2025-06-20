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

            List<String> units = new ArrayList<>();
            for (int i = 0; i < s.length(); i += count) {
                int end = Math.min(i + count, s.length());
                units.add(s.substring(i, end));
            }

            String prev = units.get(0);
            int repeatCount = 1;
            for (int i = 1; i < units.size(); i++) {
                String curr = units.get(i);
                if (prev.equals(curr)) {
                    repeatCount++;
                } else {
                    if (repeatCount > 1) {
                        sb.append(repeatCount);
                    }
                    sb.append(prev);
                    prev = curr;
                    repeatCount = 1;
                }
            }

            if (repeatCount > 1) {
                sb.append(repeatCount);
            }
            sb.append(prev);

            return sb.length();
        }
    }
}
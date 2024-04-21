package question;

/**
 * 문자열 중에 가장 많이 있는 문자열을 찾는 문제
 * ABa 라면 a
 * AABb 라면 ab
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Trend1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(
//                sol.solution("aAb")
//                sol.solution("ZBAcCBAz")
                sol.solution("qwerabcd")
        );
    }

    static class Solution {
        public String solution(String s) {
            Map<Character, Integer> alphaMap = createAlphaMap(s);

            StringBuilder sb = getResult(alphaMap);

            return Stream.of(sb.toString().split(""))
                    .sorted()
                    .collect(Collectors.joining());
        }

        private Map<Character, Integer> createAlphaMap(String s) {
            Map<Character, Integer> alphaMap = new HashMap<>();
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);

            for (char c : charArray) {
                if (Character.isLetter(c)) {
                    c = Character.toLowerCase(c);
                    alphaMap.put(c, alphaMap.getOrDefault(c, 0) + 1);
                }
            }
            return alphaMap;
        }

        private StringBuilder getResult(Map<Character, Integer> alphaMap) {
            StringBuilder sb = new StringBuilder();
            int max = -1;
            for (Map.Entry<Character, Integer> entry : alphaMap.entrySet()) {
                if (entry.getValue() > max) {
                    sb.setLength(0);
                    sb.append(entry.getKey());
                    max = entry.getValue();
                } else if (entry.getValue() == max) {
                    sb.append(entry.getKey());
                }
            }
            return sb;
        }
    }
}
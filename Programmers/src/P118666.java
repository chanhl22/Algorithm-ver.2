/**
 * 성격 유형 검사하기
 * playtime = 18m 08s
 */

import java.util.HashMap;

public class P118666 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String ans = sol.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
        System.out.println(ans);
    }

    /**
     * 지표 번호	성격 유형
     * 1번 지표	라이언형(R), 튜브형(T)
     * 2번 지표	콘형(C), 프로도형(F)
     * 3번 지표	제이지형(J), 무지형(M)
     * 4번 지표	어피치형(A), 네오형(N)
     */

    static class Solution {
        public String solution(String[] survey, int[] choices) {
            HashMap<String, Integer> map = new HashMap<>();
            map.put("R", 0);
            map.put("T", 0);
            map.put("C", 0);
            map.put("F", 0);
            map.put("J", 0);
            map.put("M", 0);
            map.put("A", 0);
            map.put("N", 0);

            for (int i = 0; i < survey.length; i++) {
                String type1 = String.valueOf(survey[i].charAt(0));
                String type2 = String.valueOf(survey[i].charAt(1));

                if (choices[i] == 1) {
                    map.put(type1, map.get(type1) + 3);
                }
                if (choices[i] == 2) {
                    map.put(type1, map.get(type1) + 2);
                }
                if (choices[i] == 3) {
                    map.put(type1, map.get(type1) + 1);
                }
                if (choices[i] == 5) {
                    map.put(type2, map.get(type2) + 1);
                }
                if (choices[i] == 6) {
                    map.put(type2, map.get(type2) + 2);
                }
                if (choices[i] == 7) {
                    map.put(type2, map.get(type2) + 3);
                }
            }

            StringBuilder sb = new StringBuilder();
            if (map.get("R") >= map.get("T")) {
                sb.append("R");
            } else {
                sb.append("T");
            }

            if (map.get("C") >= map.get("F")) {
                sb.append("C");
            } else {
                sb.append("F");
            }

            if (map.get("J") >= map.get("M")) {
                sb.append("J");
            } else {
                sb.append("M");
            }

            if (map.get("A") >= map.get("N")) {
                sb.append("A");
            } else {
                sb.append("N");
            }

            return sb.toString();
        }
    }
}

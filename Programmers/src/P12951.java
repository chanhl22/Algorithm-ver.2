/**
 * playtime = 25m 10s
 */

public class P12951 {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        String ans = sol.solution("3people unFollowed me");
//        String ans = sol.solution("for the last week");
        String ans = sol.solution("  for the what  1what  ");
//        String ans = sol.solution("a  b  c");
//        String ans = sol.solution("aaaaa aaa");
//        String ans = sol.solution(" 2v 3hello m y friend 23HIz ");
        System.out.println(ans);
    }

    static class Solution {
        public String solution(String s) {
            StringBuilder sb = new StringBuilder();

            String[] split = s.split(" ", -1);
            for (int i = 0; i < split.length; i++) {
                if (!split[i].isEmpty()) {
                    char c = split[i].charAt(0);
                    if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                        sb.append(String.valueOf(c).toUpperCase());
                        sb.append(split[i].substring(1).toLowerCase());
                    } else {
                        sb.append(split[i].toLowerCase());
                    }
                }
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);

            return sb.toString();
        }
    }
}
//playtime = 20:00

import java.util.ArrayList;

class Solution147355 {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        ArrayList<String> pieces = splitString(t, len);
        for (String piece : pieces) {
            if (piece.equals(p)) {
                answer++;
                continue;
            }
            for (int i = 0; i < len; i++) {
                int i1 = piece.charAt(i) - '0';
                int i2 = p.charAt(i) - '0';
                if (i1 < i2) {
                    answer++;
                    break;
                } else if (i1 > i2) {
                    break;
                }
            }
        }
        return answer;
    }

    private ArrayList<String> splitString(String t, int len) {
        ArrayList<String> pieces = new ArrayList<>();
        for (int i = 0; i < t.length() - len + 1; i++) {
            String sub = t.substring(i, i + len);
            pieces.add(sub);
        }
        return pieces;
    }
}

public class P147355 {
    public static void main(String[] args) {
        Solution147355 sol = new Solution147355();
        int ans = 0;
        ans = sol.solution("3141592", "271");
//        ans = sol.solution("500220839878", "7");
//        ans = sol.solution("10203", "15");
        System.out.println(ans);
    }
}
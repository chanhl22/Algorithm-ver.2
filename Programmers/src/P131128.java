// playtime = 39:43

import java.util.ArrayList;
import java.util.Collections;

class Solution131128 {
    public String solution(String X, String Y) {
        int[] count = new int[11];
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < X.length(); i++) {
            count[X.charAt(i) - '0']++;
        }

        for (int i = 0; i < Y.length(); i++) {
            if (count[Y.charAt(i) - '0']-- > 0) {
                result.add(Y.charAt(i) - '0');
            }
        }

        result.sort(Collections.reverseOrder());

        return convert(result);
    }

    private String convert(ArrayList<Integer> result) {
        if (!result.isEmpty() && result.get(0) == 0) {
            return "0";
        }
        StringBuilder answer = new StringBuilder();
        for (Integer integer : result) {
            answer.append(integer);
        }
        return answer.toString().isEmpty() ? "-1" : answer.toString();
    }
}

public class P131128 {
    public static void main(String[] args) {
        Solution131128 sol = new Solution131128();
        String ans = sol.solution("100", "2345");
//        String ans = sol.solution("100", "203045");
//        String ans = sol.solution("100", "123450");
//        String ans = sol.solution("12321", "42531");
//        String ans = sol.solution("5525", "1255");
        System.out.println(ans);
    }
}
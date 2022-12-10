import java.util.Arrays;

class Solution142086 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (alpha[s.charAt(i) - 'a'] == 0) {
                answer[i] = -1;
            } else {
                answer[i] = i + 1- alpha[s.charAt(i) - 'a'];
            }
            alpha[s.charAt(i) - 'a'] = i + 1;
        }

        return answer;
    }
}

public class P142086 {
    public static void main(String[] args) {
        Solution142086 sol = new Solution142086();
        int[] ans = sol.solution("banana"); //[-1, -1, -1, 2, 2, 2]
        System.out.println(Arrays.toString(ans));
    }
}
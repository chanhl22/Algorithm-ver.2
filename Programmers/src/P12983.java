//playtime = 02:55:16

class Solution122 {
    public int solution(String[] strs, String t) {
        int answer = 0;

        int[] dp = new int[t.length()];

        for (int i = 1; i <= t.length(); i++) { // i : 찾을 단어의 개수
            for (int j = 0; j < strs.length; j++) {
                String puzzle = strs[j];
                if (i - puzzle.length() < 0) continue;
                if (puzzle.equals(t.substring(i - puzzle.length(), i))) {
                    if (i - puzzle.length() == 0) {
                        dp[i - 1] = 1;
                        continue;
                    }
                    if (dp[i - puzzle.length() - 1] > 0) {
                        dp[i - 1] = dp[i - 1] == 0 ? dp[i - puzzle.length() - 1] + 1 : Math.min(dp[i - 1], dp[i - puzzle.length() - 1] + 1);
                    }
                }
            }
        }
        answer = dp[t.length() - 1];
        if (answer == 0) return -1;
        return answer;
    }
}

public class P12983 {
    public static void main(String[] args) {
        Solution122 sol = new Solution122();
        int ans = 0;
        ans = sol.solution(new String[]{"ba", "na", "n", "a"}, "banana");
        System.out.println(ans);
    }
}
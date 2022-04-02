package question;

class Solution119 {
    public int solution(String[] strs, String t) {
        int answer = Integer.MAX_VALUE;
        int[] dp = new int[t.length()];

        for (int i = 1; i < t.length() + 1; i++) {
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
        answer = dp[dp.length - 1];
        if (answer == 0) return -1;
        return answer;
    }
}

public class UsedCountry4 {
    public static void main(String[] args) {
        Solution119 sol = new Solution119();
        int ans = 0;
//        ans = sol.solution(new String[]{"ba","na","n","a"}, "banana");
//        ans = sol.solution(new String[]{"app","ap","p","l","e","ple","pp"}, "apple");
        ans = sol.solution(new String[]{"ba", "an", "nan", "ban", "n"}, "banana");
        System.out.println(ans);
    }
}
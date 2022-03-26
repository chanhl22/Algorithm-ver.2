//playtime = 38:54

class Solution111 {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            answer = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                answer = 2;
            }
        }
        /**
         * k는 자리수를 나타내는게 아님
         * 현재 i부터 k칸 떨어져 있다를 의미
         * ex) k = 2 일 때 i = 0, j = i + k = 2
         *                i = 1, j = i + k = 3
         * answer에 담을 때 +1을 하는 이유 : 시작 위치를 더하기 위함
         */
        for (int k = 2; k < n; k++) {
            for (int i = 0; i < n - k; i++) {
                int j = i + k;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
                    dp[i][j] = true;
                    answer = Math.max(answer, k + 1);
                }
            }
        }
        return answer;
    }
}


public class P12904 {
    public static void main(String[] args) {
        Solution111 sol = new Solution111();
        int ans = 0;
//        ans = sol.solution("abcdcba");
        ans = sol.solution("a");
        System.out.println(ans);
    }
}
package question;

class Solution74 {
    public int solution(int[][] fees, int usage) {
        int answer = 0;
        int n = fees.length;
        boolean ok = false; //기본 요금 체크
        if (usage > fees[n - 2][0]) {
            if (ok == false) {
                answer += fees[n - 1][1];
                ok = true;
            }
            int temp = usage - fees[n - 2][0];
            answer += temp * fees[n - 1][2];
            usage -= temp;
        }
        for (int i = n - 2; i >= 1; i--) {
            if (usage >= fees[i-1][0] && usage <= fees[i][0]) {
                if (ok == false) {
                    answer += fees[i][1];
                    ok = true;
                }
                int temp = usage - fees[i - 1][0];
                answer += temp * fees[i][2];
                usage -= temp;
            }
        }
        if (usage <= fees[0][0]) {
            if (ok == false) {
                answer += fees[0][1];
                ok = true;
            }
            answer += usage * fees[0][2];
        }
        return answer;
    }
}

public class KKOB1 {
    public static void main(String[] args) {
        Solution74 sol = new Solution74();
        int ans = 0;
//        ans = sol.solution(new int[][]{{200, 910, 93}, {400, 1600, 188}, {655, 7300, 281}, {0, 15372, 435}}, 320);
        ans = sol.solution(new int[][]{{200, 910, 93}, {400, 1600, 188}, {655, 7300, 281}, {0, 15372, 435}}, 450);
        System.out.println(ans);
    }
}
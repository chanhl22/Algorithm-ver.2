//playtime = 8:19

class Solution58 {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int j = i;
            while (sum <= n) {
                sum += j;
                j++;
                if (sum == n) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}


public class P12924 {
    public static void main(String[] args) {
        Solution58 sol = new Solution58();
        int ans = 0;
        ans = sol.solution(15);
        System.out.println(ans);
    }
}
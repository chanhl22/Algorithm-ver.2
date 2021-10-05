import java.util.Arrays;

class Solution35 {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            for(int j = i + 1; j < n; j++) {
                cnt++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}


public class P42584 {
    public static void main(String[] args) {
        Solution35 sol = new Solution35();
        int[] ans = sol.solution(new int[]{1, 2, 3, 2, 3});
        System.out.println(Arrays.toString(ans));
    }
}
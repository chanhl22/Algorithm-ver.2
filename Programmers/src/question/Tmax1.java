package question;

class Solution78 {
    public int solution(int[] prices) {
        int answer = -1;
        int n = prices.length;
        int benefit = 0; //이익
        boolean ok = false;
        int plus = 0;
        int minus = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                if (ok == true) {
                    benefit += prices[i];
                }
                continue;
            }
            if (minus == 3 || plus == 3) {
                if (ok == false) {
                    benefit -= prices[i];
                    ok = true;
                } else {
                    benefit += prices[i];
                    ok = false;
                }
            }
            if (prices[i] > prices[i + 1]) {
                minus++;
                plus = 0;
            } else if (prices[i] < prices[i + 1]) {
                plus++;
                minus = 0;
            } else {
                plus = 0;
                minus = 0;
            }
        }
        answer = benefit;
        return answer;
    }
}


public class Tmax1 {
    public static void main(String[] args) {
        Solution78 sol = new Solution78();
        int ans = 0;
//        ans = sol.solution(new int[]{5, 6, 7, 8});
//        ans = sol.solution(new int[]{1, 2, 3, 3, 4, 5, 5, 6, 7, 7, 8, 9, 10, 1});
        ans = sol.solution(new int[]{5, 3, 4, 6, 7, 9, 19, 18, 17, 16, 12, 14, 15, 20, 13});
        System.out.println(ans);
    }
}
//playtime = 03:25

class Solution82612 {
    public long solution(int price, int money, int count) {
        long totalPrice = 0L;
        for (int i = 1; i <= count; i++) {
            totalPrice += (long) price * i;
        }
        return money > totalPrice ? 0 : totalPrice - money;
    }
}

public class P82612 {
    public static void main(String[] args) {
        Solution82612 sol = new Solution82612();
        long ans = sol.solution(3, 20, 4);
        System.out.println(ans);
    }
}
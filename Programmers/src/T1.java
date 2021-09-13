class Solution10 {
    public long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
        // orderAmount : 주문금액
        // taxFreeAmount : 비과세금액
        // serviceFee : 봉사료
        long answer = 0;
        //부가가치세 : 과세금액 10% (소수점 첫째자리 올림)
        //과세금액 : 공금가액 - 비과세금액
        //공급가액 + 부가가치세 + 봉사료 = 주문금액
        double a = 0; //부가가치세
        double b = 0; //과세금액
        double c = 0; //공급가액
        long d = 0; //공급대가

        d = orderAmount -serviceFee;
        c = (double) (d + (taxFreeAmount / 10)) * 10 / 11;
        b = c - taxFreeAmount;
        a = b * 10 / 100;
        if (d - taxFreeAmount == 1) {
            return answer = 0;
        }
        answer = (long)Math.ceil(a);
        return answer;
    }
}

public class T1 {
    public static void main(String[] args) {
        Solution10 sol = new Solution10();
        long ans = 0;
        //ans = sol.solution(100, 0 ,0);
        //ans = sol.solution(120, 20 ,0);
        ans = sol.solution(120, 0 ,20);
        System.out.println(ans);
    }
}
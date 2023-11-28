/**
 * playtime = 06m 35s
 */

class Solution12934 {
    public long solution(long n) {
        for (long i = 1; i < 10000001; i++) {
            if (i * i == n) {
                return (i + 1) * (i + 1);
            }
        }
        return -1;
    }
}

public class P12934 {
    public static void main(String[] args) {
        Solution12934 sol = new Solution12934();
//        long ans = sol.solution(121); //144
        long ans = sol.solution(3); //-1
        System.out.println(ans);
    }
}
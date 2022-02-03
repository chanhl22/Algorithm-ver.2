//playtime = 54:38

class Solution88 {
    public long solution(int w, int h) {
        long answer = 1;
        long all = (long)w * h;
        int gcd = gcd(w, h);
        w /= gcd;
        h /= gcd;
        answer = all - (w + h - 1) * gcd;
        return answer;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}

public class P62048 {
    public static void main(String[] args) {
        Solution88 sol = new Solution88();
        long ans = 0;
//        ans = sol.solution(8, 12);
        ans = sol.solution(100000000, 99999999);
        System.out.println(ans);
    }
}
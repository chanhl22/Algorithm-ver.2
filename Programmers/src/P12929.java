//playtime = 01:32:59

class Solution106 {
    public int solution(int n) {
        int[] d = new int[n + 1];
        d[0] = 1;
        d[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                d[i] += d[i - j - 1] * d[j];
            }
        }
        return d[n];
    }
}


public class P12929 {
    public static void main(String[] args) {
        Solution106 sol = new Solution106();
        int ans = 0;
        ans = sol.solution(2);
        System.out.println(ans);
    }
}
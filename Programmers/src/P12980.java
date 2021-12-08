//playtime = 33:33

class Solution67 {
    public int solution(int n) {
        int ans = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }
        return ans;
    }
}


public class P12980 {
    public static void main(String[] args) {
        Solution67 sol = new Solution67();
        int ans = 0;
        //ans = sol.solution(5);
        //ans = sol.solution(6);
        ans = sol.solution(5000);
        System.out.println(ans);
    }
}
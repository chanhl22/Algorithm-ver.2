//playtime = 01:02:33

class Solution140107 {
    public long solution(int k, int d) {
        long answer = 0;
        for (long i = 0; i <= d; i += k) {
            long y = (long) Math.sqrt((long) Math.pow(d, 2) - (long) Math.pow(i, 2)) / k;
            answer += y + 1;
        }
        return answer;
    }
}

public class P140107 {
    public static void main(String[] args) {
        Solution140107 sol = new Solution140107();
        long ans = 0;
//        ans = sol.solution(2, 4); // 6
        ans = sol.solution(1, 5); // 26
//        ans = sol.solution(1, 1); // 3
//        ans = sol.solution(1, 2); // 6
        System.out.println(ans);
    }
}
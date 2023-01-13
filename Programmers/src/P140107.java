//playtime = 29:49
//시간초과..

class Solution140107 {
    public long solution(int k, int d) {
        long answer = 0;
        for (int i = 0; i <= d; i += k) {
            for (int j = 0; j <= d; j += k) {
                if (calDist(i, j, d)) {
                    answer += 1;
                } else {
                    break;
                }
            }
        }

        return answer;
    }

    private boolean calDist(long i, long j, long d) {
        return d * d >= i * i + j * j;
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
/**
 * playtime = 54:24
 */

class Solution181187 {
    public long solution(int r1, int r2) {
        long result = 0;

        result = findPoint1(r1, r2, result);

        return result * 4;
    }

    private long findPoint1(int r1, int r2, long result) {
        for (int i = 1; i <= r2; i++) {
            long max = (long) Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2)));
            long min = (long) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2)));
            result += max - min + 1;
        }
        return result;
    }
}

public class P181187 {
    public static void main(String[] args) {
        Solution181187 sol = new Solution181187();
        long ans = sol.solution(2, 3);
        System.out.println(ans);
    }
}
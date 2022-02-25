//playtime = 38:13

import java.util.Arrays;

class Solution98 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        int len = times.length;
        long left = 0;
        long right = (long) n * times[len - 1];
        long mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < len; i++) {
                sum += mid / times[i];
            }
            if (n <= sum) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}


public class P43238 {
    public static void main(String[] args) {
        Solution98 sol = new Solution98();
        long ans = 0;
        ans = sol.solution(6, new int[]{7, 10});
        System.out.println(ans);
    }
}
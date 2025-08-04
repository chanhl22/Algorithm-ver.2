/**
 * playtime = 03m 02s
 */

public class P70128 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
        ans = sol.solution(new int[]{1, 2, 3, 4}, new int[]{-3, -1, 0, 2});
        System.out.println(ans);
    }

    static class Solution {
        public int solution(int[] a, int[] b) {
            int answer = 0;
            int n = a.length;
            for (int i = 0; i < n; i++) {
                answer += a[i] * b[i];
            }
            return answer;
        }
    }
}
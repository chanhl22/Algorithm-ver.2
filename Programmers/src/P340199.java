/**
 * playtime = 5m 16s
 */

public class P340199 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
        ans = sol.solution(new int[]{30, 15}, new int[]{26, 17});
        System.out.println(ans);
    }

    static class Solution {
        public int solution(int[] wallet, int[] bill) {
            int w = bill[0];
            int h = bill[1];

            int count = 0;
            while (true) {
                if (w <= wallet[0] && h <= wallet[1]) {
                    return count;
                } else if (h <= wallet[0] && w <= wallet[1]) {
                    return count;
                }

                count++;
                if (w > h) {
                    w = w / 2;
                } else {
                    h = h / 2;
                }
            }
        }
    }
}
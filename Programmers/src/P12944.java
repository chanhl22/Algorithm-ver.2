/**
 * playtime = 02:13
 */

class Solution12944 {
    public double solution(int[] arr) {
        int len = arr.length;
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (double) sum / len;
    }
}

public class P12944 {
    public static void main(String[] args) {
        Solution12944 sol = new Solution12944();
        double ans = sol.solution(new int[]{1, 2, 3, 4});
        System.out.println(ans);
    }
}
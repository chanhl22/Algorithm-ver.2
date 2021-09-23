class Solution6 {
    static int go(int[] a, int index, int sum, int target) {
        int ans = 0;
        int n = a.length;
        if (index == n) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        ans += go(a, index + 1, sum + a[index], target);
        ans += go(a, index + 1, sum - a[index], target);
        return ans;
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = go(numbers, 0, 0, target);
        return answer;
    }
}


public class K43165 {
    public static void main(String[] args) {
        Solution6 sol = new Solution6();
        int ans = 0;
        ans = sol.solution(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(ans);
    }
}
class Solution64 {
    public int solution(int[] A) {
        // write your code in Java SE 11
        int n = A.length;
        int[] num = new int[100001];
        for (int i = 0; i < n; i++) {
            num[A[i]]++;
        }
        int answer = 0;
        for (int i = 1; i < 100001; i++) {
            if (num[i] == 0) {
                continue;
            }
            int temp = 0;
            if (i < num[i]) {
                temp = num[i] - i;
            } else if (i > num[i]) {
                temp = Math.min(i - num[i], num[i]);
            }
            answer += temp;
        }
        return answer;
    }
}


public class Street113 {
    public static void main(String[] args) {
        Solution64 sol = new Solution64();
        int ans = 0;
        //ans = sol.solution(new int[]{1, 1, 3, 4, 4, 4});
        //ans = sol.solution(new int[]{1, 2, 2, 2, 5, 5, 5, 8});
        //ans = sol.solution(new int[]{10, 10, 10});
        //ans = sol.solution(new int[]{1, 1, 1, 1, 3, 3, 4, 4, 4, 4, 4});
        //ans = sol.solution(new int[]{1, 2, 2, 3, 3, 3, 4});
        ans = sol.solution(new int[]{1, 2, 2, 3, 3, 3, 5, 5, 5, 5, 100, 100, 100});
        System.out.println(ans);
    }
}
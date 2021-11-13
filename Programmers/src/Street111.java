import java.util.Arrays;

class Solution62 {
    public int solution(int[] A) {
        // write your code in Java SE 11
        int answer = 0;
        Arrays.sort(A);
        int n = A.length;
        int even = 0;
        int odd = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (A[i] % 2 == 0) {
                even = A[i];
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (A[i] % 2 == 1) {
                odd = A[i];
                break;
            }
        }
        answer = even + odd;
        return answer;
    }
}

public class Street111 {
    public static void main(String[] args) {
        Solution62 sol = new Solution62();
        int ans = 0;
        //ans = sol.solution(new int[]{5, 3, 10, 6, 11});
        //ans = sol.solution(new int[]{20, 10, 7, 5});
        //ans = sol.solution(new int[]{2, 6, 4, 6});
        //ans = sol.solution(new int[]{1, 2, 1, 2, 1, 2, 2, 1});
        ans = sol.solution(new int[]{6, 6, 6, 6, 6, 6, 6, 6, 6, 6});
        System.out.println(ans);
    }
}
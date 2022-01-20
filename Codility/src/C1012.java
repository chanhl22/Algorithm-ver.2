import java.util.*;

class Solution3 {
    int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n; k++) {
            while (i < m - 1 && B[i] < A[k]) {
                i += 1;
            }
            if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }
}


public class C1012 {
    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        int ans = 0;
//        ans = sol.solution(new int[]{1, 3, 2, 1}, new int[]{4, 2, 5, 3, 2});
//        ans = sol.solution(new int[]{2, 3, 3}, new int[]{2, 1, 1});
        ans = sol.solution(new int[]{2, 1}, new int[]{3, 3});
        System.out.println(ans);
    }
}

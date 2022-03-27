package question;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution114 {
    public int solution(int[] A, int[] B) {
        int answer = -1;
        int n = A.length;
        Arrays.sort(A);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(B[i]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty()) {
                int temp = pq.remove();
                if (temp > A[i]) {
                    count++;
                    break;
                }
            }
        }
        answer = count;
        return answer;
    }
}


public class UsedCountry3 {
    public static void main(String[] args) {
        Solution114 sol = new Solution114();
        int ans = 0;
        ans = sol.solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8});
//        ans = sol.solution(new int[]{2, 2, 2, 2}, new int[]{1, 1, 1, 1});
        System.out.println(ans);
    }
}
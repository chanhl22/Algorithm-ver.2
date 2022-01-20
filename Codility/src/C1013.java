// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.LinkedList;
import java.util.Queue;

class Solution4 {
    public int solution(int[] A) {
        int n = A.length;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(A[i]);
        }
        int count = 0;
        int sum = 0;
        while (!q.isEmpty()) {
            int temp = sum;
            int cost = q.remove();
            temp += cost;
            if (temp < 0) {
                q.add(cost);
                count++;
                sum = temp - cost;
            } else if (temp == 0) {
                if (!q.isEmpty() && q.peek() < 0) {
                    q.add(cost);
                    count++;
                    sum = temp - cost;
                }
            } else {
                sum = temp;
            }
        }
        return count;
    }
}

public class C1013 {
    public static void main(String[] args) {
        Solution4 sol = new Solution4();
        int ans = 0;
//        ans = sol.solution(new int[]{10, -10, -1 ,-1, 10});
//        ans = sol.solution(new int[]{-1, -1, -1, 1, 1, 1, 1});
//        ans = sol.solution(new int[]{5, -2, -3, 1});
//        ans = sol.solution(new int[]{-1, 1});
        ans = sol.solution(new int[]{5, -2, -3, -1, -1, 1, 1});
        System.out.println(ans);
    }
}

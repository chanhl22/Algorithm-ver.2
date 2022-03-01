//playtime = 02:21:31

import java.util.*;

class Solution99 {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int count = 0;
        int jobsIdx = 0;
        int end = 0;
        while (count < jobs.length) {
            while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
                pq.add(jobs[jobsIdx]);
                jobsIdx++;
            }
            if (pq.isEmpty()) {
                end = jobs[jobsIdx][0];
            } else {
                int[] temp = pq.remove();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }
        }
        return answer / jobs.length;
    }
}

public class P42627 {
    public static void main(String[] args) {
        Solution99 sol = new Solution99();
        int ans = 0;
        ans = sol.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
        System.out.println(ans);
    }
}

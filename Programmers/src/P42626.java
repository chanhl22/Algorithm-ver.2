//playtime = 07:38

import java.util.PriorityQueue;

class Solution92 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int n = scoville.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            pq.add(scoville[i]);
        }
        while (true) {
            if (pq.peek() >= K) {
                break;
            }
            if (pq.size() == 1) {
                return -1;
            }
            answer++;
            int first = pq.remove();
            int second = pq.remove();
            int new_food = first + second * 2;
            pq.add(new_food);
        }
        return answer;
    }
}

public class P42626 {
    public static void main(String[] args) {
        Solution92 sol = new Solution92();
        int ans = 0;
        ans = sol.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
        System.out.println(ans);
    }
}
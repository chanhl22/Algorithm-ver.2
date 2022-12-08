//playtime = 31:09

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution138477 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < score.length; i++) {
            if (pq.size() == k) {
                if (pq.peek() < score[i]) {
                    pq.remove();
                    pq.add(score[i]);
                }
            } else {
                pq.add(score[i]);
            }

            if (pq.size() > k) {
                answer[i] = pq.remove();
            } else {
                answer[i] = pq.peek();
            }
        }

        return answer;
    }
}

public class P138477 {
    public static void main(String[] args) {
        Solution138477 sol = new Solution138477();
        int[] ans = sol.solution(3, new int[]{10, 100, 20, 150, 1, 100, 200});
        System.out.println(Arrays.toString(ans));
    }
}
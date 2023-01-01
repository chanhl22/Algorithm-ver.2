//playtime = 1:20:28

import java.util.PriorityQueue;

class solution142085 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        if (enemy.length <= k) {
            return enemy.length;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        for (int i = 0; i < enemy.length; i++) {
            if (i < k) {
                pq.add(enemy[i]);
            } else {
                if (pq.peek() < enemy[i]) {
                    sum += pq.remove();
                    pq.add(enemy[i]);
                } else {
                    sum += enemy[i];
                }
            }
            if (n < sum) {
                answer = i;
                break;
            } else if (n == sum) {
                answer = i + 1;
                break;
            } else {
                answer = i + 1;
            }
        }
        return answer;
    }
}

public class P142085 {
    public static void main(String[] args) {
        solution142085 sol = new solution142085();
        int ans = 0;
//        ans = sol.solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1});
        ans = sol.solution(7, 3, new int[]{5, 5, 5, 5, 2, 3, 1}); // 5
//        ans = sol.solution(1, 6, new int[]{2, 2, 2, 2, 3, 3, 1}); // 7
//        ans = sol.solution(10, 1, new int[]{2, 2, 2, 2, 2, 10}); // 6
//        ans = sol.solution(10, 1, new int[]{2, 2, 2, 2, 10}); // 5
//        ans = sol.solution(2, 4, new int[]{3, 3, 3, 3});
        System.out.println(ans);
    }
}
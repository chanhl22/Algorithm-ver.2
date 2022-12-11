//playtime = 16:24

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution131704 {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        for (int i = 1; i <= order.length; i++) {
            q1.add(i);
        }
        Stack<Integer> s2 = new Stack<>();

        int orderIdx = 0;
        while (true) {
            if (!q1.isEmpty()) {
                if (q1.peek() == order[orderIdx]) {
                    orderIdx++;
                    q1.remove();
                    answer++;
                    continue;
                }
            }

            if (!s2.isEmpty()) {
                if (s2.peek() == order[orderIdx]) {
                    orderIdx++;
                    s2.pop();
                    answer++;
                    continue;
                }
            }

            if (!q1.isEmpty()) {
                s2.push(q1.remove());
                continue;
            }

            if (q1.isEmpty()) {
                break;
            }
        }
        return answer;
    }
}

public class P131704 {
    public static void main(String[] args) {
        Solution131704 sol = new Solution131704();
//        int ans = sol.solution(new int[]{4, 3, 1, 2, 5}); // 2
        int ans = sol.solution(new int[]{5, 4, 3, 2, 1}); // 5
        System.out.println(ans);
    }
}
/**
 * 두 큐 합 같게 만들기
 * playtime = 1s 00m 23s
 */

import java.util.LinkedList;
import java.util.Queue;

public class P118667 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
//        ans = sol.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1});
//        ans = sol.solution(new int[]{1, 1}, new int[]{1, 5});
//        ans = sol.solution(new int[]{9, 7, 2}, new int[]{9, 2, 11}); //3
        ans = sol.solution(new int[]{1, 1, 1, 1, 1}, new int[]{1, 1, 1, 9, 1}); //12
        System.out.println(ans);
    }

    static class Solution {

        private static long q1Sum = 0;
        private static long q2Sum = 0;

        public int solution(int[] queue1, int[] queue2) {
            int answer = -1;

            Queue<Integer> q1 = convertQueue(queue1);
            Queue<Integer> q2 = convertQueue(queue2);

            q1Sum = findQueueSum(q1);
            q2Sum = findQueueSum(q2);

            while (true) {

                answer++;

                //최대 케이스는 q1.size() + q2.size() + 2임
                //사실 그냥 냅다 * 2로 널널하게 처리하는게 맘편
                if (answer > (q1.size() + q2.size()) + 2) {
                    return -1;
                }

                if (q1Sum == q2Sum) {
                    break;
                } else if (q1Sum > q2Sum) {
                    Integer remove = q1.remove();
                    q2.add(remove);
                    q1Sum -= remove;
                    q2Sum += remove;
                } else {
                    Integer remove = q2.remove();
                    q1.add(remove);
                    q1Sum += remove;
                    q2Sum -= remove;
                }
            }

            return answer;
        }

        private Queue<Integer> convertQueue(int[] array) {
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < array.length; i++) {
                queue.add(array[i]);
            }
            return queue;
        }

        private long findQueueSum(Queue<Integer> queue) {
            long sum = 0;
            for (Integer i : queue) {
                sum += i;
            }
            return sum;
        }
    }
}
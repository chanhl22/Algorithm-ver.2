package question.to2s;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class SolutionT12023 {
    public int solution(String s, int N) {
        int max = -1;
        boolean[] check = new boolean[10];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if (num <= N && !check[num]) {
                q.add(num);
                check[num] = true;
            } else if (num <= N) {
                while (true) {
                    int remove = q.remove();
                    check[remove] = false;
                    if (remove == num) {
                        break;
                    }
                }
                /**
                 * 같을 때 빼냐, 같을 때 안빼냐
                 * 같을 때 빼면 2번이 실패
                 * 같을 때 안 빼면 2번이 성공
                 */
//                while (!q.isEmpty() && q.peek() == num) {
//                    check[q.remove()] = false;
//                }
                q.add(num);
                check[num] = true;
            } else {
                while (!q.isEmpty()) {
                    q.remove();
                }
                Arrays.fill(check, false);
            }

            if (q.size() == N) {
                String result = "";
                for (Integer integer : q) {
                    result += integer;
                }
                max = Math.max(max, Integer.parseInt(result));
            }
        }
        return max;
    }
}

public class T12023 {
    public static void main(String[] args) {
        SolutionT12023 sol = new SolutionT12023();
        int ans = 0;
//        ans = sol.solution("1451232125", 2);
//        ans = sol.solution("313253123", 3);
//        ans = sol.solution("1321313", 3);
//        ans = sol.solution("1323313", 3);
//        ans = sol.solution("12412415", 4);
//        ans = sol.solution("123123", 3);
//        ans = sol.solution("321321", 3);
//        ans = sol.solution("13232", 3);
        ans = sol.solution("111221", 2);
        System.out.println(ans);
    }
}
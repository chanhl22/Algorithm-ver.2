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
        ans = sol.solution("51234", 5);
        System.out.println(ans);
    }
}
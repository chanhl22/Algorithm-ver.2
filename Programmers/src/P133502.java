//playtime = 41:25

import java.util.Stack;

class Solution133502 {
    public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i : ingredient) {
            stack.push(i);
            if (check(stack)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean check(Stack<Integer> stack) {
        if (stack.size() < 4) {
            return false;
        }
        int t1 = stack.pop();
        int t2 = stack.pop();
        int t3 = stack.pop();
        int t4 = stack.pop();

        if (t1 == 1 && t2 == 3 && t3 == 2 && t4 == 1) {
            return true;
        } else {
            stack.push(t4);
            stack.push(t3);
            stack.push(t2);
            stack.push(t1);
            return false;
        }
    }
}


public class P133502 {
    public static void main(String[] args) {
        Solution133502 sol = new Solution133502();
        int ans = 0;
//        ans = sol.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1});
        ans = sol.solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2});
        System.out.println(ans);
    }
}
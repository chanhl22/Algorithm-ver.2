//playtime = 16:05

import java.util.*;

class Solution104 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int len = moves.length;
        int n = board.length;
        Stack<Integer> stack = new Stack<>();
        for (int k = 0; k < len; k++) {
            for (int i = 0; i < n; i++) {
                if (board[i][moves[k] - 1] != 0) {
                    if (!stack.isEmpty() && stack.peek() == board[i][moves[k] - 1]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[i][moves[k] - 1]);
                    }
                    board[i][moves[k] - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}


public class P64061 {
    public static void main(String[] args) {
        Solution104 sol = new Solution104();
        int ans = 0;
        ans = sol.solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4});
        System.out.println(ans);
    }
}
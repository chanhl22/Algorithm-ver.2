import java.util.LinkedList;
import java.util.Queue;

class Solution7 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] check = new int[n];
        for (int i = 0; i < n; i++) {
            if (check[i] == 0) {
                answer += 1;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                check[i] = answer;
                while (!q.isEmpty()) {
                    int x = q.remove();
                    for (int j = 0; j < n; j++) {
                        if (computers[x][j] == 1 && check[j] == 0) {
                            q.add(j);
                            check[j] = answer;
                        }
                    }
                }
            }
        }
        return answer;
    }
}

public class K43162 {
    public static void main(String[] args) {
        Solution7 sol = new Solution7();
        int ans = 0;
        //ans = sol.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        //ans = sol.solution(3, new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}});
        //ans = sol.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}});
        ans = sol.solution(4, new int[][]{{1, 0, 0, 1}, {0, 1, 0, 0}, {0, 0, 1, 0}, {1, 0, 0, 1}});
        System.out.println(ans);
    }
}
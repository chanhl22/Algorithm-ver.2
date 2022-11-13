//playtime = 1:50:54

class Solution133501 {
    public int solution(int distance, int[][] scope, int[][] times) {
        int answer = 0;
        for (int i = 1; i <= distance; i++) {
            for (int j = 0; j < scope.length; j++) {
                int startScope = Math.min(scope[j][0], scope[j][1]);
                int endScope = Math.max(scope[j][0], scope[j][1]);
                if (i >= startScope && i <= endScope) {
                    int status = i % (times[j][0] + times[j][1]);
                    if (status > 0 && status <= times[j][0]) {
                        return answer + 1;
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}

public class P133501 {
    public static void main(String[] args) {
        Solution133501 sol = new Solution133501();
//        int ans = sol.solution(10, new int[][]{{3, 4}, {5, 8}}, new int[][]{{2, 5}, {4, 3}});
        int ans = sol.solution(12, new int[][]{{7, 8}, {4, 6}, {11, 10}}, new int[][]{{2, 2}, {2, 4}, {3, 3}});
        System.out.println(ans);
    }
}
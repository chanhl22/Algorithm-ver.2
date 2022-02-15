//playtime = 51:08

import java.util.Arrays;

class Solution96 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] d = new int[N][N];
        int INF = 500001;
        for (int i = 0; i < N; i++) {
            Arrays.fill(d[i], INF);
            d[i][i] = 0;
        }
        for (int i = 0; i < road.length; i++) {
            if (d[road[i][0] - 1][road[i][1] - 1] < road[i][2]) {
                continue;
            }
            d[road[i][0] - 1][road[i][1] - 1] = road[i][2];
            d[road[i][1] - 1][road[i][0] - 1] = road[i][2];
        }
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (d[i][k] + d[k][j] < d[i][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (d[0][i] <= K) {
                answer++;
            }
        }
        return answer;
    }
}

public class P12978 {
    public static void main(String[] args) {
        Solution96 sol = new Solution96();
        int ans = 0;
        ans = sol.solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3);
//        ans = sol.solution(6, new int[][]{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}}, 4);
        System.out.println(ans);
    }
}
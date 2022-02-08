//playtime = 35:42

class Solution94 {
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int[][] d = new int[n][4];
        d[0][0] = land[0][0];
        d[0][1] = land[0][1];
        d[0][2] = land[0][2];
        d[0][3] = land[0][3];
        for(int i = 1; i < n; i++) {
            int[] temp = new int[4];
            for(int j = 0; j < 4; j++) {
                temp[j] = d[i-1][j];
            }
            d[i][0] = land[i][0] + Math.max(temp[1], Math.max(temp[2], temp[3]));
            d[i][1] = land[i][1] + Math.max(temp[0], Math.max(temp[2], temp[3]));
            d[i][2] = land[i][2] + Math.max(temp[0], Math.max(temp[1], temp[3]));
            d[i][3] = land[i][3] + Math.max(temp[0], Math.max(temp[1], temp[2]));
        }
        for (int i = 0; i < 4; i++) {
            if (answer < d[n - 1][i]) {
                answer = d[n - 1][i];
            }
        }
        return answer;
    }
}


public class P12913 {
    public static void main(String[] args) {
        Solution94 sol = new Solution94();
        int ans = 0;
        ans = sol.solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}});
        System.out.println(ans);
    }
}
class Solution28 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        for (int s = 0; s < skill.length; s++) {
            if (skill[s][0] == 1) {
                for (int i = skill[s][1]; i <= skill[s][3]; i++) {
                    for (int j = skill[s][2]; j <= skill[s][4]; j++) {
                        board[i][j] -= skill[s][5];
                    }
                }
            }
            if (skill[s][0] == 2) {
                for (int i = skill[s][1]; i <= skill[s][3]; i++) {
                    for (int j = skill[s][2]; j <= skill[s][4]; j++) {
                        board[i][j] += skill[s][5];
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}


public class KK6 {
    public static void main(String[] args) {
        Solution28 sol = new Solution28();
        int ans = 0;
        //ans = sol.solution(new int[][]{{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}}, new int[][]{{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}});
        ans = sol.solution(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, new int[][]{{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}});
        System.out.println(ans);
    }
}

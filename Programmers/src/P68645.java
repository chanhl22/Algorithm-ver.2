//playtime = 01:00:00

import java.util.ArrayList;

class Solution83 {
    static int[] dx = {1, 0, -1};
    static int[] dy = {0, 1, -1};

    public int[] solution(int n) {
        int[][] map = new int[n][n];
        boolean[][] check = new boolean[n][n];
        int x = 0;
        int y = 0;
        int cnt = 1;
        int dir = 0;
        map[x][y] = cnt;
        if (n != 1) {
            while (true) {
                if (check[x][y] == true) {
                    break;
                }
                check[x][y] = true;
                map[x][y] = cnt;
                cnt++;
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if ((nx < 0 || nx >= n || ny < 0 || ny >= n) || check[nx][ny] == true) {
                    dir = (dir + 1) % 3;
                }
                x = x + dx[dir];
                y = y + dy[dir];
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    list.add(map[i][j]);
                }
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}


public class P68645 {
    public static void main(String[] args) {
        Solution83 sol = new Solution83();
        int ans[] = sol.solution(1);
        System.out.println(ans);
    }
}
//playtime = "01:21:53"

import java.util.ArrayList;
import java.util.Arrays;

class Solution81 {
    static int n;
    static int m;
    static boolean[][][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public int[] solution(String[] grid) {
        n = grid.length;
        m = grid[0].length();
        visited = new boolean[n][m][4];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    if (visited[i][j][k] == false) {
                        list.add(check_cycle(grid, i, j, k));
                    }
                }
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

    private int check_cycle(String[] grid, int x, int y, int z) {
        int cnt = 0;
        while (true) {
            if (visited[x][y][z] == true) {
                break;
            }
            visited[x][y][z] = true;
            cnt++;
            if (grid[x].charAt(y) == 'L') {
                z = (z + 1) % 4;
            } else if (grid[x].charAt(y) == 'R') {
                z = (z + 3) % 4;
            }
            x = (x + dx[z] + n) % n;
            y = (y + dy[z] + m) % m;
        }
        return cnt;
    }
}

public class P86052 {
    public static void main(String[] args) {
        Solution81 sol = new Solution81();
//        int[] ans = sol.solution(new String[]{"S"});
//        int[] ans = sol.solution(new String[]{"SL","LR"});
        int[] ans = sol.solution(new String[]{"R","R"});
        System.out.println(Arrays.toString(ans));
    }
}
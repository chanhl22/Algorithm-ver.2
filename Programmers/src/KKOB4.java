class Tower {
    int index;
    int x;
    int y;
    int group = 0;

    public Tower(int index, int x, int y) {
        this.index = index;
        this.x = x;
        this.y = y;
    }
}

class Solution77 {
    public int solution(int[][] tower, int k) {
        int answer = 0;
        int n = tower.length;
        Tower[] towers = new Tower[n];
        for (int i = 0; i < n; i++) {
            towers[i] = new Tower(i, tower[i][0], tower[i][1]);
        }
        int g = 0;
        for (int i = 0; i < n; i++) {
            if (towers[i].group == 0) {
                g++;
                towers[i].group = g;
            }
            for (int j = i + 1; j < n; j++) {
                if (towers[i].y == towers[j].y) {
                    if (towers[j].x - towers[i].x <= k) {
                        towers[j].group = towers[i].group;
                    }
                }
            }
        }
        answer = g;
        return answer;
    }
}


public class KKOB4 {
    public static void main(String[] args) {
        Solution77 sol = new Solution77();
        int ans = 0;
        ans = sol.solution(new int[][]{{0, 2}, {2, 3}, {3, 2}, {5, 3}, {6, 2}, {7, 3}, {9, 4}, {10, 2}, {11, 2}, {12, 4}, {14, 2}, {15, 3}, {16, 2}}, 3);
        System.out.println(ans);
    }
}
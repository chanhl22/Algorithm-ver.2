//playtime = 52:48

class Solution102 {
    public int solution(String dirs) {
        int answer = 0;
        int[][][] map = new int[11][11][4];
        int n = dirs.length();
        int x = 5;
        int y = 5;
        for (int i = 0; i < n; i++) {
            int nx = x;
            int ny = y;
            int d1 = 0;
            int d2 = 0;
            if (dirs.charAt(i) == 'U') {
                nx--;
                d1 = 0;
                d2 = 2;
            } else if (dirs.charAt(i) == 'D') {
                nx++;
                d1 = 2;
                d2 = 0;
            } else if (dirs.charAt(i) == 'R') {
                ny++;
                d1 = 1;
                d2 = 3;
            } else if (dirs.charAt(i) == 'L') {
                ny--;
                d1 = 3;
                d2 = 1;
            }
            if (nx >= 0 && nx < 11 && ny >= 0 && ny < 11) {
                if (map[x][y][d1] == 0 && map[nx][ny][d2] == 0) {
                    answer++;
                }
                map[x][y][d1]++;
                map[nx][ny][d2]++;
                x = nx;
                y = ny;
            }
        }
        return answer;
    }
}

public class P49994 {
    public static void main(String[] args) {
        Solution102 sol = new Solution102();
        int ans = 0;
        ans = sol.solution("ULURRDLLU");
//        ans = sol.solution("LULLLLLLU");
//        ans = sol.solution("UUUUUUDDDDDDDDDDDDDDDDD");
//        ans = sol.solution("UUURDLURDLDU");
//        ans = sol.solution("URURURURURDLDLDLDLDL");
        System.out.println(ans);
    }
}
package question;

class Solution65 {
    public int solution(String[] drum) {
        int answer = 0;
        int n = drum.length;
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = drum[i].charAt(j);
            }
        }

        for (int k = 0; k < n; k++) {
            int x = 0;
            int y = k;
            boolean check = false;
            while (true) {
                if (x < 0 || x >= n || y < 0 || y >= n) break;
                if (map[x][y] == '#') {
                    x += 1;
                } else if (map[x][y] == '>') {
                    y += 1;
                } else if (map[x][y] == '<') {
                    y -= 1;
                } else if (map[x][y] == '*') {
                    if (check) break;
                    check = true;
                    x += 1;
                }
                if (x == n - 1 && (map[x][y] == '#' || (map[x][y] == '*' && check == false))) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}


public class Dev1 {
    public static void main(String[] args) {
        Solution65 sol = new Solution65();
        int ans = 0;
        ans = sol.solution(new String[]{"######", ">#*###", "####*#", "#<#>>#", ">#*#*<", "######"});
        //ans = sol.solution(new String[]{"#", "*", "#", "#", "#", "*"});
        //ans = sol.solution(new String[]{"##", ">#", "##", "#<", ">#", "*<"});
        //ans = sol.solution(new String[]{"###", "###", "###", ">>#", "#*<", "*#*"});
        System.out.println(ans);
    }
}
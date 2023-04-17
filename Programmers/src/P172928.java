/**
 * playtime = 53:24
 */

import java.util.Arrays;

class Solution172928 {
    public int[] solution(String[] park, String[] routes) {
        char[][] map = init(park);

        int[] point = findStart(map);

        int x = point[0];
        int y = point[1];
        for (String route : routes) {
            int[] find = move(route, x, y);
            if (checkMove(map, find, x, y)) {
                x = find[0];
                y = find[1];
            }
        }

        return new int[]{x, y};
    }

    private boolean checkMove(char[][] map, int[] find, int x, int y) {
        int n = map.length;
        int m = map[0].length;
        if (find[0] < 0 || find[0] >= n || find[1] < 0 || find[1] >= m) {
            return false;
        }
        for (int i = x; i <= find[0]; i++) {
            if (map[i][y] == 'X') {
                return false;
            }
        }
        for (int i = find[0]; i <= x; i++) {
            if (map[i][y] == 'X') {
                return false;
            }
        }
        for (int i = y; i <= find[1]; i++) {
            if (map[x][i] == 'X') {
                return false;
            }
        }
        for (int i = find[1]; i <= y; i++) {
            if (map[x][i] == 'X') {
                return false;
            }
        }
        return true;
    }

    private int[] move(String route, int x, int y) {
        String[] temp = route.split(" ");
        if (temp[0].equals("E")) {
            int i = Integer.parseInt(temp[1]);
            y += i;
        }
        if (temp[0].equals("W")) {
            int i = Integer.parseInt(temp[1]);
            y -= i;
        }
        if (temp[0].equals("S")) {
            int i = Integer.parseInt(temp[1]);
            x += i;
        }
        if (temp[0].equals("N")) {
            int i = Integer.parseInt(temp[1]);
            x -= i;
        }
        return new int[]{x, y};
    }

    private int[] findStart(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'S') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    private char[][] init(String[] park) {
        int n = park.length;
        int m = park[0].length();
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = park[i].toCharArray();
        }
        return map;
    }
}

public class P172928 {
    public static void main(String[] args) {
        Solution172928 sol = new Solution172928();
//        int[] ans = sol.solution(new String[]{"SOO","OOO","OOO"}, new String[]{"E 2","S 2","W 1"});
//        int[] ans = sol.solution(new String[]{"SOO","OXX","OOO"}, new String[]{"E 2","S 2","W 1"});
//        int[] ans = sol.solution(new String[]{"SOO","XXO","XOO"}, new String[]{"E 2","S 2","W 1"});
        int[] ans = sol.solution(new String[]{"OSO","OOO"}, new String[]{"E 2","S 2","W 1"});
        System.out.println(Arrays.toString(ans));
    }
}
/**
 * playtime = 14:32
 */

import java.util.Arrays;

class Solution161990 {
    public int[] solution(String[] wallpaper) {
        int n = wallpaper.length;
        int m = wallpaper[0].length();

        char[][] map = init(wallpaper, n, m);

        int startX = findStartX(map, n, m);
        int startY = findStartY(map, n, m);
        int endX = findEndX(map, n, m);
        int endY = findEndY(map, n, m);

        return new int[]{startX, startY, endX + 1, endY + 1};

    }

    private int findStartX(char[][] map, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '#') {
                    return i;
                }
            }
        }
        return 0;
    }

    private int findStartY(char[][] map, int n, int m) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[j][i] == '#') {
                    return i;
                }
            }
        }
        return 0;
    }

    private int findEndX(char[][] map, int n, int m) {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (map[i][j] == '#') {
                    return i;
                }
            }
        }
        return 0;
    }

    private int findEndY(char[][] map, int n, int m) {
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (map[j][i] == '#') {
                    return i;
                }
            }
        }
        return 0;
    }

    private char[][] init(String[] wallpaper, int n, int m) {
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = wallpaper[i].toCharArray();
        }
        return map;
    }
}

public class P161990 {
    public static void main(String[] args) {
        Solution161990 sol = new Solution161990();
//        int[] ans = sol.solution(new String[]{".#...", "..#..", "...#."});
        int[] ans = sol.solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."});
        System.out.println(Arrays.toString(ans));
    }
}
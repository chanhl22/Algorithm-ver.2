/**
 * playtime = 40:41
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Position159993 {
    int x;
    int y;

    public Position159993(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution159993 {
    public static final int[] dx = {0, 0, -1, 1};
    public static final int[] dy = {-1, 1, 0, 0};

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        char[][] map = new char[n][m];
        for (int i = 0; i < map.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        int result1 = findLever(map, n, m);
        if (result1 == -1) {
            return -1;
        }
        int result2 = findExit(map, n, m);
        if (result2 == -1) {
            return -1;
        }
        return result1 + result2;
    }

    private int findLever(char[][] map, int n, int m) {
        Position159993 startPoint = findStart(map, 'S');
        if (startPoint.x == -1 && startPoint.y == -1) {
            return -1;
        }

        return bfs(map, n, m, startPoint, 'L');
    }

    private int findExit(char[][] map, int n, int m) {
        Position159993 startPoint = findStart(map, 'L');
        if (startPoint.x == -1 && startPoint.y == -1) {
            return -1;
        }
        return bfs(map, n, m, startPoint, 'E');
    }

    private static int bfs(char[][] map, int n, int m, Position159993 startPoint, char endPoint) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startPoint.x);
        q.add(startPoint.y);
        int[][] check = new int[n][m];
        for (int[] arr : check) {
            Arrays.fill(arr, -1);
        }
        check[startPoint.x][startPoint.y] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if ((map[nx][ny] == 'O' || map[nx][ny] == 'L' || map[nx][ny] == 'E' || map[nx][ny] == 'S')
                            && check[nx][ny] == -1) {
                        q.add(nx);
                        q.add(ny);
                        check[nx][ny] = check[x][y] + 1;
                        if (map[nx][ny] == endPoint) {
                            return check[nx][ny];
                        }
                    }
                }
            }
        }
        return -1;
    }

    private Position159993 findStart(char[][] map, char startPoint) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == startPoint) {
                    return new Position159993(i, j);
                }
            }
        }
        return new Position159993(-1, -1);
    }
}

public class P159993 {
    public static void main(String[] args) {
        Solution159993 sol = new Solution159993();
//        int ans = sol.solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"});
        int ans = sol.solution(new String[]{"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"});
        System.out.println(ans);
    }
}
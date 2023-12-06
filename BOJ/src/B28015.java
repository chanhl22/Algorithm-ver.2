/**
 * playtime = 33m 26s
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B28015 {

    private static int n;
    private static int m;
    private static int[][] map;
    private static boolean[][] isVisited;

    public static void main(String[] args) {
        input();
        System.out.println(solution());
    }

    private static int solution() {
        isVisited = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean isFirst = true;
            for (int j = 0; j < m; j++) {
                if (!isFirst && map[i][j] == 0) {
                    isFirst = true;
                }
                if (!isVisited[i][j] && map[i][j] != 0) {
                    if (isFirst) {
                        update(map[i][j], i, j);
                        count++;
                        isFirst = false;
                    } else {
                        bfs(map[i][j], i, j);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static void update(int standard, int i, int j) {
        for (int k = j; k < m; k++) {
            if (map[i][k] == 0) {
                break;
            }
            if (map[i][k] == standard) {
                isVisited[i][k] = true;
            }
        }
    }

    private static void bfs(int standard, int i, int j) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        q.add(j);
        isVisited[i][j] = true;
        while(!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            int nx = x;
            int ny = y + 1;
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (!isVisited[nx][ny] && map[nx][ny] == standard) {
                    q.add(nx);
                    q.add(ny);
                    isVisited[nx][ny] = true;
                }
            }
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
    }
}

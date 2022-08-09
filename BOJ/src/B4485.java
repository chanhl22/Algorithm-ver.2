//playtime = 42:39

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B4485 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = 1;
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            System.out.println("Problem " + index + ": " + bfs(map, n));
            index++;
        }
    }

    private static int bfs(int[][] map, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(0);
        int[][] minAmount = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(minAmount[i], -1);
        }
        minAmount[0][0] = map[0][0];
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    int sum = minAmount[x][y] + map[nx][ny];
                    if (minAmount[nx][ny] == -1 || sum < minAmount[nx][ny]) {
                        minAmount[nx][ny] = sum;
                        q.add(nx);
                        q.add(ny);
                    }
                }
            }
        }
        return minAmount[n-1][n-1];
    }
}

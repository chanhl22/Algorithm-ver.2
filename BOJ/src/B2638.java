//playtime = 18:43

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2638 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int answer = 0;
        while (true) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] != 0) {
                        cnt++;
                    }
                }
            }
            if (cnt == 0) break;
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            q.add(0);
            int[][] dist = new int[n][m];
            dist[0][0] = 2;
            while (!q.isEmpty()) {
                int x = q.remove();
                int y = q.remove();
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (map[nx][ny] == 0) {
                            q.add(nx);
                            q.add(ny);
                            map[nx][ny] = 2;
                        } else if (map[nx][ny] == 1) {
                            map[nx][ny] = 3;
                        } else if (map[nx][ny] == 3) {
                            map[nx][ny] = 4;
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 2 || map[i][j] == 4) {
                        map[i][j] = 0;
                    } else if (map[i][j] == 3) {
                        map[i][j] = 1;
                    }
                }
            }
            answer++;
        }
        System.out.println(answer);
    }
}

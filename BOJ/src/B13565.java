//playtime = 09:39

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B13565 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < m; i++) {
            if (map[0][i] == 0) {
                q.add(0);
                q.add(i);
                visited[0][i] = true;
            }
        }
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 0 && visited[nx][ny] == false) {
                        q.add(nx);
                        q.add(ny);
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        boolean ok = false;
        for (int i = 0; i < m; i++) {
            if (visited[n-1][i] == true) {
                ok = true;
            }
        }
        System.out.println(ok == true ? "YES" : "NO");
    }
}

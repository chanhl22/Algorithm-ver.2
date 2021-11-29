//playtime = 13:39

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16433 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int[][] d = new int[n][n];
        d[r][c] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(r);
        q.add(c);
        boolean[][] check = new boolean[n][n];
        check[r][c] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (check[nx][ny] == false) {
                        q.add(nx);
                        q.add(ny);
                        check[nx][ny] = true;
                        d[nx][ny] = d[x][y] + 1;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (d[i][j] % 2 == 0) {
                    System.out.print('v');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
    }
}

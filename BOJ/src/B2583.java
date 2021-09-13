import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2583 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        boolean[][] a = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            int sy = sc.nextInt();
            int sx = sc.nextInt();
            int ey = sc.nextInt();
            int ex = sc.nextInt();
            for (int l1 = sx; l1 < ex; l1++) {
                for (int l2 = sy; l2 < ey; l2++) {
                    a[l1][l2] = true;
                }
            }
        }
        int record = 0;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == true || dist[i][j] != 0) continue;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                q.add(j);
                record++;
                dist[i][j] = record;
                while (!q.isEmpty()) {
                    int x = q.remove();
                    int y = q.remove();
                    for (int l = 0; l < 4; l++) {
                        int nx = x + dx[l];
                        int ny = y + dy[l];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                            if (a[nx][ny] == false && dist[nx][ny] == 0) {
                                q.add(nx);
                                q.add(ny);
                                dist[nx][ny] = record;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(record);
        int[] ans = new int[record];
        for (int i = 0; i < record; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (dist[j][l] == i+1) {
                        ans[i] += 1;
                    }
                }
            }
        }
        Arrays.sort(ans);
        for (int i = 0; i < record; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

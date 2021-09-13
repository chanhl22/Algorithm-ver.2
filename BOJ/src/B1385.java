import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1385 {
    static int[] dx = {-1, 0, 1, 1, 0, -1};
    static int[] dy = {1, 1, 0, -1, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[2001][2001];
        int x = 1000;
        int y = 1000;
        a[x][y] = 1;
        int cur = 2;
        for (int level = 1; level <= 1000; level++) {
            //우선 한칸 위로 올림
            x += dx[5];
            y += dy[5];
            //올리고 나서 현재 숫자 증가시킴
            a[x][y] = cur++;
            // 방향 순서대로 a 채움
            for (int i = 0; i <= 5; i++) { //방향
                int loop = level;
                if (i == 0) loop -= 1;
                for (int j = 0; j < loop; j++) {
                    x += dx[i];
                    y += dy[i];
                    a[x][y] = cur++;
                }
            }
        }
        //각각의 a배열의 값의 x,y 좌표를 알야아함
        int[] coord_x = new int[2000001];
        int[] coord_y = new int[2000001];
        for (int i = 0; i < 2001; i++) {
            for (int j = 0; j < 2001; j++) {
                if (a[i][j] != 0 && a[i][j] <= 1000000) {
                    coord_x[a[i][j]] = i;
                    coord_y[a[i][j]] = j;
                }
            }
        }

        //입력값 거꾸로 받음
        int ed = sc.nextInt();
        int st = sc.nextInt();
        int[] dist = new int[2000001];
        Arrays.fill(dist, -1);
        int[] from = new int[2000001];
        Arrays.fill(from, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        dist[st] = 0;
        from[st] = 0;
        while (!q.isEmpty()) {
            int now = q.remove();
            x = coord_x[now];
            y = coord_y[now];
            for (int k = 0; k < 6; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < 2001 && ny >= 0 && ny < 2001) {
                    if (a[nx][ny] != 0) {
                        int next = a[nx][ny];
                        if (dist[next] == -1) {
                            q.add(next);
                            dist[next] = dist[now] + 1;
                            from[next] = now;
                        }
                    }
                }
            }
        }
        System.out.print(ed + " ");
        while (st != ed) {
            ed = from[ed];
            System.out.print(ed + " ");
        }
    }
}

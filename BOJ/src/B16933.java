import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair13 {
    int x;
    int y;
    int z;
    int night;

    Pair13(int x, int y, int z, int night) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.night = night;
    }
}

public class B16933 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt(); //Break wall count
        int[][] a = new int[n][m];
        sc.nextLine();
        //input info
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        //record in b[][][]
        //Break wall and move & move blank
        int[][][][] b = new int[n][m][k + 1][2];
        b[0][0][0][0] = 1;
        //bfs
        Queue<Pair13> q = new LinkedList<>();
        q.offer(new Pair13(0, 0, 0, 0));
        while (!q.isEmpty()) {
            Pair13 p = q.remove();
            int x = p.x;
            int y = p.y;
            int z = p.z;
            int night = p.night;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (a[nx][ny] == 0 && b[nx][ny][z][1 - night] == 0) {
                        q.offer(new Pair13(nx, ny, z, 1 - night));
                        b[nx][ny][z][1 - night] = b[x][y][z][night] + 1;
                    }
                    if (night == 0 && z + 1 <= k && a[nx][ny] == 1 && b[nx][ny][z + 1][1 - night] == 0) {
                        q.offer(new Pair13(nx, ny, z + 1, 1 - night));
                        b[nx][ny][z + 1][1 - night] = b[x][y][z][night] + 1;
                    }
                }
            }
            if (b[x][y][z][1 - night] == 0) {
                b[x][y][z][1 - night] = b[x][y][z][night] + 1;
                q.offer(new Pair13(x, y, z, 1 - night));
            }
        }
        //print
        int ans = -1;
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < 2; j++) {
                if (b[n - 1][m - 1][i][j] == 0) continue;
                if (ans == -1) {
                    ans = b[n - 1][m - 1][i][j];
                } else {
                    ans = Math.min(ans, b[n - 1][m - 1][i][j]);
                }
            }
        }
        System.out.println(ans);
    }
}

//playtime = 34:02

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B6593 {
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int L = sc.nextInt();
            int R = sc.nextInt();
            int C = sc.nextInt();
            sc.nextLine();

            if (L == 0 && R == 0 && C == 0) break;

            char[][][] building = new char[R][C][L];
            int start_x = 0;
            int start_y = 0;
            int start_z = 0;
            int end_x = 0;
            int end_y = 0;
            int end_z = 0;
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = sc.nextLine();
                    for (int k = 0; k < C; k++) {
                        building[j][k][i] = str.charAt(k);
                        if (building[j][k][i] == 'S') {
                            start_x = j;
                            start_y = k;
                            start_z = i;
                            building[j][k][i] = '.';
                        }
                        if (building[j][k][i] == 'E') {
                            end_x = j;
                            end_y = k;
                            end_z = i;
                            building[j][k][i] = '.';
                        }
                    }
                }
                sc.nextLine();
            }

            bfs(L, R, C, start_x, start_y, start_z, end_x, end_y, end_z, building);
        }
    }

    private static void bfs(int l, int r, int c, int start_x, int start_y, int start_z, int end_x, int end_y, int end_z, char[][][] building) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start_x);
        q.add(start_y);
        q.add(start_z);
        int[][][] visited = new int[r][c][l];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < l; k++) {
                    visited[i][j][k] = -1;
                }
            }
        }
        visited[start_x][start_y][start_z] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            int z = q.remove();
            for (int k = 0; k < 6; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                int nz = z + dz[k];
                if (nx >= 0 && nx < r && ny >= 0 && ny < c && nz >= 0 && nz < l) {
                    if (visited[nx][ny][nz] == -1 && building[nx][ny][nz] != '#') {
                        q.add(nx);
                        q.add(ny);
                        q.add(nz);
                        visited[nx][ny][nz] = visited[x][y][z] + 1;
                    }
                }
            }
        }
        if (visited[end_x][end_y][end_z] != -1) {
            System.out.println("Escaped in " + visited[end_x][end_y][end_z] + " minute(s).");
        } else {
            System.out.println("Trapped!");
        }
    }
}

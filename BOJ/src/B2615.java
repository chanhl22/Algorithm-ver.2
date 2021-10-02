//Best Solution
//https://coder-in-war.tistory.com/entry/BOJ-JAVA2615-%EC%98%A4%EB%AA%A9

import java.util.Scanner;

public class B2615 {
    static boolean bfs(int x, int y, int dir_x, int dir_y, int dxn, int dyn, int[][] a) {
        int nx = x;
        int ny = y;
        if (x + dxn >= 0 && x + dxn < 19 && y + dyn >= 0 && y + dyn < 19) {
            if (a[x + dxn][y + dyn] == a[x][y]) {
                return false;
            }
        }
        for (int i = 0; i < 5; i++) {
            nx += dir_x;
            ny += dir_y;
            if (i < 4) {
                if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19) {

                } else {
                    return false;
                }
            }
            if (i == 4 && nx >= 0 && nx < 19 && ny >= 0 && ny < 19) {
                if (a[nx][ny] == a[x][y]) {
                    return false;
                } else {
                    return true;
                }
            }
            if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19) {
                if (a[nx][ny] == a[x][y]) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                if (a[i][j] != 0) {
                    boolean ok = false;
                    for (int k = 0; k < 8; k++) {
                        int dxn = (k + 4) % 8;
                        int dyn = (k + 4) % 8;
                        ok = bfs(i, j, dx[k], dy[k], dx[dxn], dy[dyn], a);
                        if (ok) {
                            System.out.println(a[i][j]);
                            System.out.print(i + 1 + " ");
                            System.out.println(j + 1);
                            System.exit(0);
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }
}
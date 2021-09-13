import java.util.Scanner;

public class B14620 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int n;
    static int[][] a;

    static void flower(int x, int y, boolean[][] check) {
        check[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                check[nx][ny] = true;
            }
        }
    }

    static int cal(boolean[][] check) {
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j] == true) {
                    ret += a[i][j];
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = -1;
        for (int i1 = 0; i1 < n; i1++) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int i2 = 0; i2 < n; i2++) {
                    for (int j2 = 0; j2 < n; j2++) {
                        if (i1 == i2 && j1 == j2) continue;
                        for (int i3 = 0; i3 < n; i3++) {
                            for (int j3 = 0; j3 < n; j3++) {
                                if (i1 == i3 && j1 == j3 || i2 == i3 && j2 == j3) continue;
                                boolean[][] check = new boolean[n][n];
                                flower(i1,j1,check);
                                flower(i2,j2,check);
                                flower(i3,j3,check);
                                int count = 0;
                                for (int i = 0; i < n; i++) {
                                    for (int j = 0; j < n; j++) {
                                        if (check[i][j] == true) {
                                            count++;
                                        }
                                    }
                                }
                                if (count == 15) {
                                    int temp = cal(check);
                                    if (ans == -1 || ans > temp) {
                                        ans = temp;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}

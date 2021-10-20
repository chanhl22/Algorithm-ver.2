import java.util.Scanner;

public class B3678 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dx = {-1, -1, 0, 1, 1, 0};
        int[] dy = {1, 0, -1, -1, 0, 1};
        int[] r = {1, 2, 3, 4, 5};
        int[][] a = new int[51][51];
        int[][] b = new int[51][51];
        int x = 25;
        int y = 25;
        a[x][y] = 1;
        b[x][y] = 1;
        b[x][y + 1] = 2;
        b[x - 1][y + 1] = 3;
        b[x - 1][y] = 4;
        b[x][y - 1] = 5;
        int cur = 2;
        for (int level = 1; level <= 4; level++) {
            x += dx[5];
            y += dy[5];
            a[x][y] = cur++;
            for (int k = 0; k < 6; k++) {
                int loop = level;
                if (k == 0) loop -= 1;
                for (int i = 0; i < loop; i++) {
                    x += dx[k];
                    y += dy[k];
                    a[x][y] = cur++;
                    if (cur > 6) {
                        boolean[] check = new boolean[6];
                        for (int j = 0; j < 6; j++) {
                            int nx = x + dx[j];
                            int ny = y + dy[j];
                            for (int l = 1; l <= 5; l++) {
                                if (a[nx][ny] == l) {
                                    check[l] = true;
                                }
                            }
                        }
                        for (int j = 1; j < 6; j++) {
                            if (check[j] == false) {
                                b[x][y] = j;
                                break;
                            }
                        }
                    }
                }
            }
        }
//        for (int i = 0; i < 51; i++) {
//            for (int j = 0; j < 51; j++) {
//                System.out.print(b[i][j] + " ");
//            }
//            System.out.println();
//        }
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 0; i < 101; i++) {
                for (int j = 0; j < 101; j++) {
                    if (a[i][j] == n) {
                        System.out.println(b[i][j]);
                    }
                }
            }
        }
    }
}

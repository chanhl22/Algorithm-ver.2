import java.util.Arrays;
import java.util.Scanner;

public class B2571 {
    static int[][] a;
    static int ans = 0;

    static boolean check_zero(int x, int y, int n, int m) {
        for (int i = x; i <= x + n; i++) {
            for (int j = y; j <= y + m; j++) {
                if (a[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static void check(int x, int y) {
        for (int i = 1; i < 100; i++) {
            if (x + i >= 100 || a[x + i][y] == 0) {
                break;
            }
            for (int j = 1; j < 100; j++) {
                if (y + j >= 100 || a[x][y + j] == 0) {
                    break;
                }
                if (check_zero(x, y, i, j)) {
                    int temp = (i + 1) * (j + 1);
                    if (ans < temp) {
                        ans = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[100][100];
        for (int k = 0; k < n; k++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    a[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                check(i, j);
            }
        }
        System.out.println(ans);
    }
}

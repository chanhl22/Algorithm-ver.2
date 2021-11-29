//playtime = 37:26

import java.util.Scanner;

public class B1780 {
    static int[][] a;
    static int minus = 0;
    static int plus = 0;
    static int zero = 0;

    static void go(int x, int y, int size) {
        if (check(x, y, size)) {
            if (a[x][y] == -1) {
                minus++;
            } else if (a[x][y] == 0) {
                zero++;
            } else {
                plus++;
            }
            return;
        }
        for (int i = x; i < x + size; i += size / 3) {
            for (int j = y; j < y + size; j += size / 3) {
                go(i, j, size / 3);
            }
        }
    }

    static boolean check(int x, int y, int size) {
        int s = a[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (a[i][j] != s) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        go(0, 0, n);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }
}

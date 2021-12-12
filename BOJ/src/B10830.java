//playtime = 59:23

import java.util.Scanner;

public class B10830 {
    static int n;
    final static int MOD = 1000;
    static int[][] a;

    static int[][] pow(int[][] a, long b) {
        if (b == 1L) {
            return a;
        }
        int ret[][] = pow(a, b / 2);
        ret = multiply(ret, ret);
        if (b % 2 == 1L) {
            ret = multiply(ret, a);
        }
        return ret;
    }

    private static int[][] multiply(int[][] ret1, int[][] ret2) {
        int[][] ret = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    ret[i][j] += ret1[i][k] * ret2[k][j];
                    ret[i][j] %= MOD;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        long b = sc.nextLong();
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt() % MOD;
            }
        }
        int[][] result = pow(a, b);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}

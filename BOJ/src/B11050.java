//playtime = 13:24

import java.util.Scanner;

public class B11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] d = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            d[i][0] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                d[i][j] = d[i - 1][j - 1] + d[i - 1][j];
            }
        }
        System.out.println(d[n][k]);
    }
}

/**
 * Add Solution
 * Top-Down
 */
//import java.util.Scanner;
//
//public class B11050 {
//    static int[][] d;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        d = new int[n + 1][n + 1];
//        System.out.println(print(n, k));
//    }
//
//    private static int print(int n, int k) {
//        if (d[n][k] > 0) {
//            return d[n][k];
//        }
//        if (n == k || k == 0) {
//            return d[n][k] = 1;
//        }
//        return d[n][k] = print(n - 1, k - 1) + print(n - 1, k);
//    }
//}
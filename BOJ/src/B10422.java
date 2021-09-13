import java.util.Arrays;
import java.util.Scanner;

public class B10422 {
    static long[] d = new long[5001];
    static long mod = 1000000007L;

    static long go(int n) {
        if (n == 0) {
            return 1;
        }
        if (d[n] != -1) {
            return d[n];
        }
        d[n] = 0;
        for (int i = 2; i <= n; i += 2) {
            d[n] += go(i - 2) * go(n - i);
            d[n] %= mod;
        }
        return d[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arrays.fill(d, -1);
        int t = sc.nextInt();
        ;
        while (t-- > 0) {
            int l = sc.nextInt();
            if (l % 2 == 0) {
                System.out.println(go(l));
            } else {
                System.out.println(0);
            }
        }
    }
}

//import java.util.*;
//public class Main {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        long[][] d = new long[5001][5001];
//        long mod = 1000000007L;
//        d[0][0] = 1;
//        for (int i=1; i<=5000; i++) {
//            for (int j=0; j<=i; j++) {
//                d[i][j] = 0;
//                if (j+1 <= i) {
//                    d[i][j] += d[i-1][j+1];
//                }
//                if (j-1 >= 0) {
//                    d[i][j] += d[i-1][j-1];
//                }
//                d[i][j] %= mod;
//            }
//        }
//        int t = sc.nextInt();
//        while (t-- > 0) {
//            int n = sc.nextInt();
//            System.out.println(d[n][0]);
//        }
//    }
//}
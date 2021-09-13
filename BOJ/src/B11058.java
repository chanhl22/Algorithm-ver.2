import java.util.Scanner;

public class B11058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] d = new long[n+1];
        d[0] = 0;
        d[1] = 1;
        if (n == 1) {
            System.out.println(d[n]);
            System.exit(0);
        }
        d[2] = 2;
        if (n == 2) {
            System.out.println(d[n]);
            System.exit(0);
        }
        d[3] = 3;
        if (n == 3) {
            System.out.println(d[n]);
            System.exit(0);
        }
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j < i-2; j++) {
                long temp = Math.max(d[i-1] + 1, d[i-(j+2)] * (j+1));
                if (d[i] < temp){
                    d[i] = temp;
                }
            }
        }
        System.out.println(d[n]);
    }
}

//Simple Solution
//import java.util.*;
//
//public class B11058 {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        long[] d = new long[n+1];
//        for (int i=1; i<=n; i++) {
//            d[i] = d[i-1] + 1;
//            for (int j=1; j<=i-3; j++) {
//                long cur = d[i-j-2]*(j+1);
//                if (cur > d[i]) {
//                    d[i] = cur;
//                }
//            }
//        }
//        System.out.println(d[n]);
//    }
//}
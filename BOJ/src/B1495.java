import java.util.Scanner;

public class B1495 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //count
        int s = sc.nextInt(); //first volume
        int m = sc.nextInt(); //volume range
        int[] v = new int[n+1];
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
        }
        boolean[][] d = new boolean[n+1][m+1];
        d[0][s] = true;
        for (int i = 0; i <= n-1; i++) {
            for (int j = 0; j <= m; j++) {
                if (d[i][j] == false) {
                    continue;
                }
                if (j - v[i+1] >= 0) {
                    d[i+1][j-v[i+1]] = true;
                }
                if (j + v[i+1] <= m) {
                    d[i+1][j+v[i+1]] = true;
                }
            }
        }
        int ans = -1;
        for (int i = 0; i <= m; i++) {
            if (d[n][i]) ans = i;
        }
        System.out.println(ans);
    }
}

//Another solution
//import java.util.*;
//public class Main {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int[] w = new int[n+1];
//        int[] v = new int[n+1];
//        for (int i=1; i<=n; i++) {
//            w[i] = sc.nextInt();
//            v[i] = sc.nextInt();
//        }
//        int[] d = new int[k+1];
//        for (int i=1; i<=n; i++) {
//            for (int j=k; j>=1; j--) {
//                if (j-w[i] >= 0) {
//                    d[j] = Math.max(d[j], d[j-w[i]]+v[i]);
//                }
//            }
//        }
//        System.out.println(d[k]);
//    }
//}

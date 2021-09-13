import java.util.Scanner;

public class B11048_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n+1][m+1];
        int[][] d = new int[n+1][m+1];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        d[0][0] = a[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (d[i][j+1] < d[i][j] + a[i][j+1]){
                    d[i][j+1] = d[i][j] + a[i][j+1];
                }
                if (d[i+1][j] < d[i][j] + a[i+1][j]){
                    d[i+1][j] = d[i][j] + a[i+1][j];
                }
                if (d[i+1][j+1] < d[i][j] + a[i+1][j+1]){
                    d[i+1][j+1] = d[i][j] + a[i+1][j+1];
                }
            }
        }
        System.out.println(d[n-1][m-1]);
    }
}

//Another Solution, check range
//import java.util.*;
//
//public class B11048_2 {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[][] a = new int[n+1][m+1];
//        int[][] d = new int[n+1][m+1];
//        for (int i=1; i<=n; i++) {
//            for (int j=1; j<=m; j++) {
//                a[i][j] = sc.nextInt();
//            }
//        }
//        d[1][1] = a[1][1];
//        for (int i=1; i<=n; i++) {
//            for (int j=1; j<=m; j++) {
//                if (j+1 <= m && d[i][j+1] < d[i][j] + a[i][j+1]) {
//                    d[i][j+1] = d[i][j] + a[i][j+1];
//                }
//                if (i+1 <= n && d[i+1][j] < d[i][j] + a[i+1][j]) {
//                    d[i+1][j] = d[i][j] + a[i+1][j];
//                }
//                if (i+1 <= n && j+1 <= m && d[i+1][j+1] < d[i][j] + a[i+1][j+1]) {
//                    d[i+1][j+1] = d[i][j] + a[i+1][j+1];
//                }
//            }
//        }
//        System.out.println(d[n][m]);
//    }
//}
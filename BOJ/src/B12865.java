import java.util.Scanner;

public class B12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        //D[i][j] : i번째 물건까지 고려했고, 배낭에 넣은 물건 무게의 합이 j일 때, 가치의 최대값
        //1. i번째 물건을 넣지 않을 경우 : D[i-1][j]
        //2. i번째 물건을 넣을 경우 : D[i-1][j-w[i]] + v[i];
        int[][] d = new int[n + 1][k + 1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= k; j++) {
                d[i][j] = d[i-1][j];
                if (j - w[i] >= 0) {
                    d[i][j] = Math.max(d[i][j], d[i-1][j-w[i]] + v[i]);
                }
            }
        }
        System.out.println(d[n][k]);
    }
}

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

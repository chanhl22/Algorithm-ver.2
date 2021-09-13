import java.util.Scanner;

public class B2422 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][] a = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[x][y] = a[y][x] = true;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (a[i][j] == false) {
                    for (int k = j+1; k <= n; k++) {
                        if (a[i][k] == false && a[j][k] == false){
                            ans += 1;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}

//import java.util.*;
//public class Main {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        boolean[][] a = new boolean[201][201];
//        while (m-- > 0) {
//            int u = sc.nextInt();
//            int v = sc.nextInt();
//            a[u][v] = a[v][u] = true;
//        }
//        int ans = 0;
//        for (int i=1; i<=n-2; i++) {
//            for (int j=i+1; j<=n-1; j++) {
//                for (int k=j+1; k<=n; k++) {
//                    if (a[i][j] || a[j][k] || a[k][i]) continue;
//                    ans += 1;
//                }
//            }
//        }
//        System.out.println(ans);
//    }
//}
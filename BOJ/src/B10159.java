import java.util.Arrays;
import java.util.Scanner;

public class B10159 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(a[i], 10000);
        }
        for (int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[x][y] = 1;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    if (a[i][k] + a[k][j] < a[i][j]) {
                        a[i][j] = a[i][k] + a[k][j];
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (a[i][j] == 10000 && a[j][i] == 10000) {
                    cnt++;
                }
            }
            System.out.println(cnt - 1);
        }
    }
}

//Another Solution
//import java.util.Scanner;
//
//public class B10159 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[][] a = new int[n + 1][n + 1];
//        for (int i = 1; i <= m; i++) {
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            a[x][y] = 1;
//        }
//        for (int k = 1; k <= n; k++) {
//            for (int i = 1; i <= n; i++) {
//                for (int j = 1; j <= n; j++) {
//                    if (i == j) continue;
//                    //단방향이므로 i->k 와 k->j가 된다면 i->j에 1을 넣어줌
//                    if (a[i][k] == 1 && a[k][j] == 1) {
//                        a[i][j] = 1;
//                    }
//                }
//            }
//        }
//        for (int i = 1; i <= n; i++) {
//            int cnt = 0;
//            for (int j = 1; j <= n; j++) {
//                //i에서 j로 가는길도없고, j에서 i로 가는길도 없을때 ++
//                if (a[i][j] == 0 && a[j][i] == 0) {
//                    cnt++;
//                }
//            }
//            System.out.println(cnt - 1);
//        }
//    }
//}
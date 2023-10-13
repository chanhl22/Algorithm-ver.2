/**
 * playtime = 37:55
 */

import java.util.Scanner;

public class B16931 {

    private static int n;
    private static int m;
    private static int[][] input;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        input = new int[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                input[i][j] = sc.nextInt();
            }
        }
    }

    private static void solution() {
        int result = 2 * n * m;
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= m; y++) {
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (input[x][y] - input[nx][ny] > 0) {
                        result += input[x][y] - input[nx][ny];
                    }
                }
            }
        }
        System.out.println(result);
    }
}

//import java.util.Scanner;
//
//public class B16931{
//    final static int[] dx = {0,0,0,0,1,-1};
//    final static int[] dy = {0,0,1,-1,0,0};
//    final static int[] dz = {1,-1,0,0,0,0};
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[][] a = new int[102][102];
//        boolean[][][] d = new boolean[102][102][102];
//        for (int i=1; i<=n; i++) {
//            for (int j=1; j<=m; j++) {
//                a[i][j] = sc.nextInt();
//                for (int k=1; k<=a[i][j]; k++) {
//                    d[i][j][k] = true;
//                }
//            }
//        }
//        int ans = 0;
//        for (int x=1; x<=n; x++) {
//            for (int y=1; y<=m; y++) {
//                for (int z=1; z<=a[x][y]; z++) {
//                    for (int k=0; k<6; k++) {
//                        int nx = x+dx[k];
//                        int ny = y+dy[k];
//                        int nz = z+dz[k];
//                        if (d[nx][ny][nz] == false) ans += 1;
//                    }
//                }
//            }
//        }
//        System.out.println(ans);
//    }
//}


//import java.util.*;
//public class Main {
//    final static int[] dx = {0,0,1,-1};
//    final static int[] dy = {1,-1,0,0};
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[][] a = new int[102][102];
//        for (int i=1; i<=n; i++) {
//            for (int j=1; j<=m; j++) {
//                a[i][j] = sc.nextInt();
//            }
//        }
//        int ans = 2*n*m;
//        for (int x=1; x<=n; x++) {
//            for (int y=1; y<=m; y++) {
//                for (int k=0; k<4; k++) {
//                    int nx = x+dx[k];
//                    int ny = y+dy[k];
//                    if (a[x][y]-a[nx][ny] >= 0) {
//                        ans += a[x][y]-a[nx][ny];
//                    }
//                    }
//            }
//        }
//        System.out.println(ans);
//    }
//}

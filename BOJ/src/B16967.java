import java.util.Scanner;

public class B16967 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] a = new int[h + x][w + y];
        for (int i = 0; i < h + x; i++) {
            for (int j = 0; j < w + y; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                a[i + x][j + y] -= a[i][j];
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}

//import java.util.Scanner;
//
//public class B16967 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        int[][] a = new int[n][m];
//        int[][] b = new int[n + x][m + y];
//        for (int i = 0; i < n + x; i++) {
//            for (int j = 0; j < m + y; j++) {
//                b[i][j] = sc.nextInt();
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (i < x && j < m) {
//                    a[i][j] = b[i][j];
//                } else if (i < n && j < y) {
//                    a[i][j] = b[i][j];
//                } else if (i >= x && i < n && j >= y && j < m) {
//                    a[i][j] = b[i][j] - a[i - x][j - y];
//                }
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(a[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//}
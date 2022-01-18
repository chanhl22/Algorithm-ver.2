import java.util.Scanner;

public class B2580 {
    static final int n = 9;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        go(0);
    }

    private static void go(int index) {
        if (index == 81) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }
        int x = index / n;
        int y = index % n;
        if (map[x][y] != 0) {
            go(index + 1);
        } else {
            for (int i = 1; i <= n; i++) {
                //행, 열, 사각형 체크
                if (row_check(i, x, y) && col_check(i, x, y) && square_check(i, x, y)) {
                    map[x][y] = i;
                    go(index + 1);
                    map[x][y] = 0;
                }
            }
        }
    }

    private static boolean row_check(int v, int x, int y) {
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (map[x][i] != 0) {
                check[map[x][i] - 1] = true;
            }
        }
        if (check[v - 1] == false) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean col_check(int v, int x, int y) {
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (map[i][y] != 0) {
                check[map[i][y] - 1] = true;
            }
        }
        if (check[v - 1] == false) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean square_check(int v, int x, int y) {
        boolean[] check = new boolean[9];
        for (int i = 0; i < n; i++) {
            if (map[(x / 3) * 3 + (i / 3)][(y / 3) * 3 + (i % 3)] != 0) {
                check[map[(x / 3) * 3 + (i / 3)][(y / 3) * 3 + (i % 3)] - 1] = true;
            }
        }
        if (check[v - 1] == false) {
            return true;
        } else {
            return false;
        }
    }
}

//Best Solution
//import java.util.Scanner;
//
//public class B2580 {
//    public static final int n = 9;
//    public static int square(int x, int y) {
//        return (x/3)*3+(y/3);
//    }
//    public static boolean go(int[][] a, boolean[][][] c, int z) {
//        if (z == 81) {
//            for (int i=0; i<n; i++) {
//                for (int j=0; j<n; j++) {
//                    System.out.print(a[i][j] + " ");
//                }
//                System.out.println();
//            }
//            return true;
//        }
//        int x = z/n;
//        int y = z%n;
//        if (a[x][y] != 0) {
//            return go(a, c, z+1);
//        } else {
//            for (int i=1; i<=9; i++) {
//                if (!c[0][x][i] && !c[1][y][i] && !c[2][square(x,y)][i]) {
//                    c[0][x][i] = c[1][y][i] = c[2][square(x,y)][i] = true;
//                    a[x][y] = i;
//                    if (go(a, c, z+1)) {
//                        return true;
//                    }
//                    a[x][y] = 0;
//                    c[0][x][i] = c[1][y][i] = c[2][square(x,y)][i] = false;
//                }
//            }
//        }
//        return false;
//    }
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int[][] a = new int[n][n];
//        boolean[][][] c = new boolean[3][n][10];
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                a[i][j] = sc.nextInt();
//                if (a[i][j] != 0) {
//                    c[0][i][a[i][j]] = true;
//                    c[1][j][a[i][j]] = true;
//                    c[2][square(i,j)][a[i][j]] = true;
//                }
//            }
//        }
//        go(a, c, 0);
//    }
//}

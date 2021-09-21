import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2636 {
    static int n;
    static int m;
    static int[][] a;
    static boolean[][] check;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};


    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(0);
        check[0][0] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (check[nx][ny] == false && a[nx][ny] == 0) {
                        q.add(nx);
                        q.add(ny);
                        check[nx][ny] = true;
                    } else if (a[nx][ny] == 1) {
                        a[nx][ny] = 2;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        int cnt = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 1) {
                    cnt++;
                }
            }
        }
        while (true) {
            check = new boolean[n][m];
            bfs();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] == 2) {
                        a[i][j] = 0;
                    }
                }
            }
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] == 1) {
                        c++;
                    }
                }
            }
            time++;
            if (c == 0) {
                break;
            }
            cnt = c;
        }
        System.out.println(time);
        System.out.println(cnt);
    }
}

//Refactoring required
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Main {
//    static int n;
//    static int m;
//    static int[][] a;
//    static boolean[][] check;
//    static int[] dx = {0, 0, -1, 1};
//    static int[] dy = {-1, 1, 0, 0};
//
//
//    static void bfs() {
//        Queue<Integer> q = new LinkedList<>();
//        q.add(0);
//        q.add(0);
//        check[0][0] = true;
//        while (!q.isEmpty()) {
//            int x = q.remove();
//            int y = q.remove();
//            for (int k = 0; k < 4; k++) {
//                int nx = x + dx[k];
//                int ny = y + dy[k];
//                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
//                    if (check[nx][ny] == false && a[nx][ny] == 0) {
//                        q.add(nx);
//                        q.add(ny);
//                        check[nx][ny] = true;
//                    }
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//        a = new int[n][m];
//        int cnt = 0;
//        int time = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                a[i][j] = sc.nextInt();
//                if (a[i][j] == 1) {
//                    cnt++;
//                }
//            }
//        }
//        while (true) {
//            check = new boolean[n][m];
//            bfs();
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    if (a[i][j] == 0 && check[i][j] == true) {
//                        if (i - 1 >= 0 && a[i - 1][j] == 1) {
//                            a[i - 1][j] = 2;
//                        }
//                        if (i + 1 < n && a[i + 1][j] == 1) {
//                            a[i + 1][j] = 2;
//                        }
//                        if (j - 1 >= 0 && a[i][j - 1] == 1) {
//                            a[i][j - 1] = 2;
//                        }
//                        if (j + 1 < m && a[i][j + 1] == 1) {
//                            a[i][j + 1] = 2;
//                        }
//                    }
//                }
//            }
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    if (a[i][j] == 2) {
//                        a[i][j] = 0;
//                    }
//                }
//            }
//            int c = 0;
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    if (a[i][j] == 1) {
//                        c++;
//                    }
//                }
//            }
//            time++;
//            if (c == 0) {
//                break;
//            }
//            cnt = c;
//        }
//        System.out.println(time);
//        System.out.println(cnt);
//    }
//}
/**
 * playtime = 36m 14s
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B4963 {

    public static Scanner sc = new Scanner(System.in);
    public static int w;
    public static int h;
    public static int[][] map;
    public static boolean[][] flag;
    public static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    public static int[] dy = {-1, 1, 0, 0, -1, 1, 1, -1};

    public static void main(String[] args) {
        while (true) {
            input();

            if (w == 0 && h == 0) {
                return;
            }

            System.out.println(solution());
        }
    }

    private static void input() {
        h = sc.nextInt();
        w = sc.nextInt();

        map = new int[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                map[i][j] = sc.nextInt();
            }
        }
    }

    private static int solution() {
        flag = new boolean[w][h];

        int count = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (flag[i][j]) {
                    continue;
                }

                if(map[i][j] == 0) {
                    continue;
                }

                bfs(i, j);
                count++;
            }
        }
        return count;
    }

    private static void bfs(int sx, int sy) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sx);
        q.add(sy);
        flag[sx][sy] = true;

        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < w && ny >= 0 && ny < h && !flag[nx][ny] && map[nx][ny] == 1) {
                    flag[nx][ny] = true;
                    q.add(nx);
                    q.add(ny);
                }
            }
        }
    }

}

//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class B4963 {
//    static int n;
//    static int m;
//    static int a[][];
//    static boolean check[][];
//    static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
//    static int[] dy = {-1, 1, 0, 0, -1, 1, 1, -1};
//
//    static void bfs(int i, int j) {
//        Queue<Integer> q = new LinkedList<>();
//        q.add(i);
//        q.add(j);
//        check[i][j] = true;
//        while (!q.isEmpty()) {
//            int x = q.remove();
//            int y = q.remove();
//            for (int k = 0; k < 8; k++) {
//                int nx = x + dx[k];
//                int ny = y + dy[k];
//                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
//                    if (check[nx][ny] == false && a[nx][ny] == 1) {
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
//        while (true) {
//            m = sc.nextInt();
//            n = sc.nextInt();
//            if (n == 0 && m == 0) {
//                break;
//            }
//            a = new int[n][m];
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    a[i][j] = sc.nextInt();
//                }
//            }
//            check = new boolean[n][m];
//            int cnt = 0;
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    if (a[i][j] == 1 && check[i][j] == false) {
//                        bfs(i, j);
//                        cnt++;
//                    }
//                }
//            }
//            System.out.println(cnt);
//        }
//    }
//}

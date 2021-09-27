import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B3197 {
    static int n;
    static int m;
    static char[][] a;
    static int[] swan;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] dist;

    static int bfs() {
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == '.') {
                    q.add(i);
                    q.add(j);
                    dist[i][j] = 0;
                }
            }
        }
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (dist[nx][ny] == -1) {
                        q.add(nx);
                        q.add(ny);
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int temp = dist[i][j];
                if (ans < temp) {
                    ans = temp;
                }
            }
        }
        return ans;
    }

    static boolean meet(int mid) {
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = dist[i][j];
                if (temp[i][j] <= mid) {
                    temp[i][j] = 0;
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[][] c = new boolean[n][m];
        q.add(swan[0]);
        q.add(swan[1]);
        c[swan[0]][swan[1]] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (c[nx][ny] == false && temp[nx][ny] == 0) {
                        q.add(nx);
                        q.add(ny);
                        c[nx][ny] = true;
                    }
                }
            }
        }
        return c[swan[2]][swan[3]];
    }

    static int binarysearch(int melt) {
        int low = 0;
        int high = melt;
        int mid = 0;
        while(low <= high) {
            mid = (low + high)/2;
            boolean ok = meet(mid); //true 만남, false 못만남
            if (!ok) { //못만남
                low = mid + 1;
            } else { //만남
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];
        swan = new int[4];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
                if (a[i][j] == 'L') {
                    a[i][j] = '.';
                    swan[cnt] = i;
                    swan[cnt + 1] = j;
                    cnt += 2;
                }
            }
        }
        int melt = bfs();
        int ans = binarysearch(melt);
        System.out.println(ans);
    }
}

//TimeOut
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class B3197 {
//    static int n;
//    static int m;
//    static char[][] a;
//    static int[] swan;
//    static boolean[][] check;
//    static int[] dx = {0, 0, -1, 1};
//    static int[] dy = {-1, 1, 0, 0};
//
//    static void bfs(int i, int j) {
//        Queue<Integer> q = new LinkedList<>();
//        q.add(i);
//        q.add(j);
//        check[i][j] = true;
//        while (!q.isEmpty()) {
//            int x = q.remove();
//            int y = q.remove();
//            for (int k = 0; k < 4; k++) {
//                int nx = x + dx[k];
//                int ny = y + dy[k];
//                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
//                    if (check[nx][ny] == false && a[nx][ny] == '.') {
//                        q.add(nx);
//                        q.add(ny);
//                        check[nx][ny] = true;
//                    }
//                    if (a[nx][ny] == 'X') {
//                        a[nx][ny] = 'O';
//                    }
//                }
//            }
//        }
//    }
//
//    static boolean swan_bfs() {
//        Queue<Integer> q = new LinkedList<>();
//        boolean[][] c = new boolean[n][m];
//        q.add(swan[0]);
//        q.add(swan[1]);
//        c[swan[0]][swan[1]] = true;
//        while (!q.isEmpty()) {
//            int x = q.remove();
//            int y = q.remove();
//            for (int k = 0; k < 4; k++) {
//                int nx = x + dx[k];
//                int ny = y + dy[k];
//                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
//                    if (c[nx][ny] == false && a[nx][ny] == '.') {
//                        q.add(nx);
//                        q.add(ny);
//                        c[nx][ny] = true;
//                    }
//                }
//            }
//        }
//        return c[swan[2]][swan[3]];
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//        a = new char[n][m];
//        swan = new int[4];
//        int cnt = 0;
//        for (int i = 0; i < n; i++) {
//            String s = sc.next();
//            for (int j = 0; j < m; j++) {
//                a[i][j] = s.charAt(j);
//                if (a[i][j] == 'L') {
//                    a[i][j] = '.';
//                    swan[cnt] = i;
//                    swan[cnt + 1] = j;
//                    cnt += 2;
//                }
//            }
//        }
//        check = new boolean[n][m];
//        int ans = 0;
//        while (true) {
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    if (check[i][j] == false && a[i][j] == '.') {
//                        bfs(i, j);
//                    }
//                }
//            }
//            for (int k = 0; k < n; k++) {
//                for (int l = 0; l < m; l++) {
//                    if (a[k][l] == 'O') {
//                        a[k][l] = '.';
//                    }
//                }
//            }
//            ans++;
//            if (swan_bfs()) {
//                break;
//            }
//        }
//        System.out.println(ans);
//    }
//}

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Pair9376 {
    int x;
    int y;

    public Pair9376(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class B9376 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int[][] bfs(char[][] a, int x, int y) {
        int h = a.length;
        int w = a[0].length;
        Deque<Pair9376> dq = new ArrayDeque<>();
        int[][] d = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                d[i][j] = -1;
            }
        }
        boolean[][] check = new boolean[h][w];
        dq.add(new Pair9376(x, y));
        d[x][y] = 0;
        check[x][y] = true;
        while (!dq.isEmpty()) {
            Pair9376 p = dq.poll();
            int px = p.x;
            int py = p.y;
            for (int k = 0; k < 4; k++) {
                int nx = px + dx[k];
                int ny = py + dy[k];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (a[nx][ny] == '*') continue;
                if (check[nx][ny] == true) continue;
                if (a[nx][ny] == '.') {
                    dq.addFirst(new Pair9376(nx, ny));
                    check[nx][ny] = true;
                    d[nx][ny] = d[px][py];
                }
                if (a[nx][ny] == '#') {
                    dq.addLast(new Pair9376(nx, ny));
                    check[nx][ny] = true;
                    d[nx][ny] = d[px][py] + 1;
                }
            }
        }
        return d;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            sc.nextLine();
            char[][] a = new char[h + 2][w + 2];
            for (int i = 0; i < h + 2; i++) {
                for (int j = 0; j < w + 2; j++) {
                    a[i][j] = '.';
                }
            }
            int[] criminal = new int[6];
            int x = 0;
            int y = 0;
            criminal[0] = 0;
            criminal[1] = 0;
            int cnt = 2;
            for (int i = 1; i < h + 1; i++) {
                String s = sc.nextLine();
                for (int j = 1; j < w + 1; j++) {
                    a[i][j] = s.charAt(j - 1);
                    if (a[i][j] == '$') {
                        criminal[cnt] = i;
                        criminal[cnt + 1] = j;
                        cnt += 2;
                        a[i][j] = '.';
                    }
                }
            }
            int[][] dist1 = bfs(a, criminal[0], criminal[1]);
            int[][] dist2 = bfs(a, criminal[2], criminal[3]);
            int[][] dist3 = bfs(a, criminal[4], criminal[5]);

            int ans = Integer.MAX_VALUE;
            for (int i = 1; i < h+1; i++) {
                for (int j = 1; j < w+1; j++) {
                    if (a[i][j] == '*') continue;
                    if(dist1[i][j] == -1 || dist2[i][j] == -1 || dist3[i][j] == -1) continue;
                    int temp = dist1[i][j] + dist2[i][j] + dist3[i][j];
                    if (a[i][j] == '#'){
                        temp -= 2;
                    }
                    if (ans > temp){
                        ans = temp;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}

//another solution
//import java.util.*;
//class Pair {
//    int x, y;
//    Pair(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
//
//public class Main {
//    public static int[] dx = {1, -1, 0, 0};
//    public static int[] dy = {0, 0, 1, -1};
//    public static int[][] bfs(String[] a, int x, int y) {
//        int n = a.length;
//        int m = a[0].length();
//        int[][] d = new int[n][m];
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<m; j++) {
//                d[i][j] = -1;
//            }
//        }
//        ArrayDeque<Pair> deque = new ArrayDeque<Pair>();
//        deque.add(new Pair(x, y));
//        d[x][y] = 0;
//        while (!deque.isEmpty()) {
//            Pair p = deque.poll();
//            x = p.x;
//            y = p.y;
//            for (int k=0; k<4; k++) {
//                int nx = x+dx[k];
//                int ny = y+dy[k];
//                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
//                if (d[nx][ny] != -1) continue;
//                char c = a[nx].charAt(ny);
//                if (c == '*') continue;
//                if (c == '#') {
//                    d[nx][ny] = d[x][y] + 1;
//                    deque.addLast(new Pair(nx, ny));
//                } else {
//                    d[nx][ny] = d[x][y];
//                    deque.addFirst(new Pair(nx, ny));
//                }
//            }
//        }
//        return d;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while (t-- > 0) {
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            sc.nextLine();
//            String[] a = new String[n+2];
//            for (int i=1; i<=n; i++) {
//                a[i] = sc.nextLine();
//                a[i] = "." + a[i] + ".";
//            }
//            n += 2;
//            m += 2;
//            a[0] = a[n-1] = "";
//            for (int j=0; j<m; j++) {
//                a[0] += ".";
//                a[n-1] += ".";
//            }
//            int[][] d0 = bfs(a, 0, 0);
//            int x1, y1, x2, y2;
//            x1 = y1 = x2 = y2 = -1;
//            for (int i=0; i<n; i++) {
//                for (int j=0; j<m; j++) {
//                    if (a[i].charAt(j) == '$') {
//                        if (x1 == -1) {
//                            x1 = i;
//                            y1 = j;
//                        } else {
//                            x2 = i;
//                            y2 = j;
//                        }
//                    }
//                }
//            }
//            int[][] d1 = bfs(a, x1, y1);
//            int[][] d2 = bfs(a, x2, y2);
//            int ans = n*m;
//            for (int i=0; i<n; i++) {
//                for (int j=0; j<m; j++) {
//                    char c = a[i].charAt(j);
//                    if (c == '*') continue;
//                    if (d0[i][j] == -1 || d1[i][j] == -1 || d2[i][j] == -1) continue;
//                    int cur = d0[i][j] + d1[i][j] + d2[i][j];
//                    if (c == '#') cur -= 2;
//                    if (ans > cur) ans = cur;
//                }
//            }
//            System.out.println(ans);
//        }
//    }
//}
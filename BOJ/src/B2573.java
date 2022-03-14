//playtime = 01:09:27

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2573 {
    static int n;
    static int m;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int year = 0;
        while (true) {
            if (separation()) {
                break;
            }
            if (allMelt()) {
                year = 0;
                break;
            }
            melt();
            year++;
        }
        System.out.println(year);
    }

    private static boolean separation() {
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && visited[i][j] == false) {
                    bfs(visited, i, j);
                    count++;
                }
            }
        }
        return count >= 2 ? true : false;
    }

    private static boolean allMelt() {
        boolean iceberg = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    iceberg = false;
                }
            }
        }
        return iceberg;
    }

    private static void melt() {
        int[][] delete = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    int zeroCount = 0;
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < n && y >= 0 && y < m) {
                            if (map[x][y] == 0) {
                                zeroCount++;
                            }
                        }
                    }
                    delete[i][j] = zeroCount;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] -= delete[i][j];
                if (map[i][j] < 0) {
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs(boolean[][] visited, int sx, int sy) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sx);
        q.add(sy);
        visited[sx][sy] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (visited[nx][ny] == false && map[nx][ny] != 0) {
                        q.add(nx);
                        q.add(ny);
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}


////need to Refactoring
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class B2573 {
//    static int n;
//    static int m;
//    static int[][] a;
//    static int[] dx = {0, 0, -1, 1};
//    static int[] dy = {-1, 1, 0, 0};
//
//    static void bfs(int sx, int sy, boolean[][] check) {
//        Queue<Integer> q = new LinkedList<>();
//        q.add(sx);
//        q.add(sy);
//        check[sx][sy] = true;
//        while (!q.isEmpty()) {
//            int x = q.remove();
//            int y = q.remove();
//            for (int k = 0; k < 4; k++) {
//                int nx = x + dx[k];
//                int ny = y + dy[k];
//                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
//                    if (a[nx][ny] != 0 && check[nx][ny] == false) {
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
//        int ans = 0;
//        a = new int[n][m];
//        int ice_x = 0; //얼음이 있는 첫 번째 x좌표
//        int ice_y = 0; //얼음이 있는 첫 번째 y좌표
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                a[i][j] = sc.nextInt();
//                if (a[i][j] != 0 && ice_x == 0 && ice_y == 0) {
//                    ice_x = i;
//                    ice_y = j;
//                }
//            }
//        }
//        boolean[][] first = new boolean[n][m];
//        bfs(ice_x, ice_y, first);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (a[i][j] != 0 && first[i][j] == false) {
//                    System.out.println(ans);
//                    System.exit(0);
//                }
//            }
//        }
//        int temp = 0;
//        while (true) {
//            int[][] melt = new int[n][m];
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    if (a[i][j] != 0) {
//                        int cnt = 0;
//                        for (int k = 0; k < 4; k++) {
//                            int x = i + dx[k];
//                            int y = j + dy[k];
//                            if (a[x][y] == 0) {
//                                cnt++;
//                            }
//                        }
//                        melt[i][j] = cnt;
//                    }
//                }
//            }
//            int sx = 0; //녹은 후 첫 번째 빙산 x좌표
//            int sy = 0; //녹은 후 첫 번째 빙산 y좌표
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    a[i][j] -= melt[i][j];
//                    if (a[i][j] < 0) {
//                        a[i][j] = 0;
//                    }
//                    if (a[i][j] > 0 && sx == 0 && sy == 0) {
//                        sx = i;
//                        sy = j;
//                    }
//                }
//            }
//            boolean[][] check = new boolean[n][m];
//            bfs(sx, sy, check);
//            boolean ok = false; //분리됨을 체크하기 위한 변수
//            int c = 0; //전부 녹았다는 것을 체크하기 위한 변수
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    if (a[i][j] != 0 && check[i][j] == false) {
//                        ans = temp + 1;
//                        ok = true;
//                        break;
//                    } else if (a[i][j] == 0) {
//                        c++;
//                    }
//                }
//                if (ok) {
//                    break;
//                }
//            }
//            if (ok) {
//                break;
//            }
//            if (c == n * m) {
//                break;
//            }
//            temp++;
//        }
//        System.out.println(ans);
//    }
//}

//playtime = 44:00

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair11 {
    int x;
    int y;
    int z;

    public Pair11(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class B2206 {
    static int n;
    static int m;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        input();
        bfs();
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Pair11> q = new LinkedList<>();
        q.add(new Pair11(0, 0, 0));
        int[][][] visited = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 2; k++) {
                    visited[i][j][k] = -1;
                }
            }
        }
        visited[0][0][0] = 1;
        while (!q.isEmpty()) {
            Pair11 p = q.remove();
            int x = p.x;
            int y = p.y;
            int z = p.z;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (visited[nx][ny][z] == -1 && map[nx][ny] == 0) {
                        q.add(new Pair11(nx, ny, z));
                        visited[nx][ny][z] = visited[x][y][z] + 1;
                    }
                    if (z == 0 && visited[nx][ny][z] == -1) {
                        q.add(new Pair11(nx, ny, z + 1));
                        visited[nx][ny][z + 1] = visited[x][y][z] + 1;
                    }
                }
            }
        }
        return calcDistance(visited);
    }

    private static int calcDistance(int[][][] visited) {
        if (visited[n - 1][m - 1][0] == -1 && visited[n - 1][m - 1][1] == -1) {
            return -1;
        } else if (visited[n - 1][m - 1][0] == -1) {
            return visited[n - 1][m - 1][1];
        } else if (visited[n - 1][m - 1][1] == -1) {
            return visited[n - 1][m - 1][0];
        } else {
            return Math.min(visited[n - 1][m - 1][0], visited[n - 1][m - 1][1]);
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
    }
}


//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//class Pair11 {
//    int x;
//    int y;
//    int z;
//
//    Pair11(int x, int y, int z) {
//        this.x = x;
//        this.y = y;
//        this.z = z;
//    }
//}
//
//public class B2206 {
//   static int[] dx = {-1,1,0,0};
//   static int[] dy = {0,0,-1,1};
//
//   public static void main(String[] args) {
//       Scanner sc = new Scanner(System.in);
//       int n = sc.nextInt();
//       int m = sc.nextInt();
//       int[][] a = new int[n][m];
//       sc.nextLine();
//       //input info
//       for (int i = 0; i < n; i++) {
//           String s = sc.nextLine();
//           for (int j = 0; j < m; j++) {
//               a[i][j] = s.charAt(j) - '0';
//           }
//       }
//       //record in b[][][]
//       //Break wall and move & move blank
//       int[][][] b = new int[n][m][2];
//       b[0][0][0] = 1;
//       //bfs
//       Queue<Pair11> q = new LinkedList<>();
//       q.add(new Pair11(0, 0, 0));
//       while (!q.isEmpty()) {
//           Pair11 p = q.remove();
//           int x = p.x;
//           int y = p.y;
//           int z = p.z;
//           for (int i = 0; i < 4; i++) {
//               int nx = x + dx[i];
//               int ny = y + dy[i];
//               if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
//                   if (a[nx][ny] == 0 && b[nx][ny][z] == 0){
//                       q.add(new Pair11(nx,ny,z));
//                       b[nx][ny][z] = b[x][y][z] + 1;
//                   }
//                   if(z == 0 && a[nx][ny] == 1 && b[nx][ny][z+1] == 0) {
//                       q.add(new Pair11(nx,ny,z+1));
//                       b[nx][ny][z+1] = b[x][y][z] + 1;
//                   }
//               }
//           }
//       }
//       //print
//       if (b[n - 1][m - 1][0] != 0 && b[n - 1][m - 1][1] != 0) {
//           if (b[n - 1][m - 1][0] < b[n - 1][m - 1][1]) {
//               System.out.println(b[n - 1][m - 1][0]);
//           } else {
//               System.out.println(b[n - 1][m - 1][1]);
//           }
//       } else if (b[n - 1][m - 1][0] != 0) {
//           System.out.println(b[n - 1][m - 1][0]);
//       } else if (b[n - 1][m - 1][1] != 0) {
//           System.out.println(b[n - 1][m - 1][1]);
//       } else {
//           System.out.println("-1");
//       }
//   }
//}

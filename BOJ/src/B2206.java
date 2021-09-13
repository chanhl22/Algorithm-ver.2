import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair11 {
    int x;
    int y;
    int z;

    Pair11(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class B2206 {
   static int[] dx = {-1,1,0,0};
   static int[] dy = {0,0,-1,1};

   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int m = sc.nextInt();
       int[][] a = new int[n][m];
       sc.nextLine();
       //input info
       for (int i = 0; i < n; i++) {
           String s = sc.nextLine();
           for (int j = 0; j < m; j++) {
               a[i][j] = s.charAt(j) - '0';
           }
       }
       //record in b[][][]
       //Break wall and move & move blank
       int[][][] b = new int[n][m][2];
       b[0][0][0] = 1;
       //bfs
       Queue<Pair11> q = new LinkedList<>();
       q.add(new Pair11(0, 0, 0));
       while (!q.isEmpty()) {
           Pair11 p = q.remove();
           int x = p.x;
           int y = p.y;
           int z = p.z;
           for (int i = 0; i < 4; i++) {
               int nx = x + dx[i];
               int ny = y + dy[i];
               if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                   if (a[nx][ny] == 0 && b[nx][ny][z] == 0){
                       q.add(new Pair11(nx,ny,z));
                       b[nx][ny][z] = b[x][y][z] + 1;
                   }
                   if(z == 0 && a[nx][ny] == 1 && b[nx][ny][z+1] == 0) {
                       q.add(new Pair11(nx,ny,z+1));
                       b[nx][ny][z+1] = b[x][y][z] + 1;
                   }
               }
           }
       }
       //print
       if (b[n - 1][m - 1][0] != 0 && b[n - 1][m - 1][1] != 0) {
           if (b[n - 1][m - 1][0] < b[n - 1][m - 1][1]) {
               System.out.println(b[n - 1][m - 1][0]);
           } else {
               System.out.println(b[n - 1][m - 1][1]);
           }
       } else if (b[n - 1][m - 1][0] != 0) {
           System.out.println(b[n - 1][m - 1][0]);
       } else if (b[n - 1][m - 1][1] != 0) {
           System.out.println(b[n - 1][m - 1][1]);
       } else {
           System.out.println("-1");
       }
   }
}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B6087 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt(); //col
        int h = sc.nextInt(); //row
        sc.nextLine();
        int sx = -1; //start x
        int sy = -1; //start y
        int ex = -1; //end x
        int ey = -1; //end y
        char[][] a = new char[h][w];
        for (int i = 0; i < h; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < w; j++) {
                a[i][j] = s.charAt(j);
                if (a[i][j] == 'C') {
                    if (sx == -1 && sy == -1) {
                        sx = i;
                        sy = j;
                    } else {
                        ex = i;
                        ey = j;
                    }
                }
            }
        }
        int[][] d = new int[h][w]; //Record dist
        //init -1
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                d[i][j] = -1;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(sx);
        q.add(sy);
        d[sx][sy] = 0; //start point
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                while (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                    if (a[nx][ny] == '*') break; //If you hit the wall
                    if (d[nx][ny] == -1) {
                        d[nx][ny] = d[x][y] + 1;
                        q.add(nx);
                        q.add(ny);
                    }
                    nx += dx[k];
                    ny += dy[k];
                }
            }
        }
        System.out.println(d[ex][ey] - 1);
    }
}

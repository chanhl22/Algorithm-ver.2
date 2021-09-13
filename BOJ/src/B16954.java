import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16954 {
    static int[] dx = {0, 0, 1, -1, -1, 1, -1, 1, 0};
    static int[] dy = {1, -1, 0, 0, -1, -1, 1, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] a = new char[8][8];
        //input
        for (int i = 0; i < 8; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < 8; j++) {
                a[i][j] = s.charAt(j);
            }
        }
        //bfs
        Queue<Integer> q = new LinkedList<>();
        boolean check[][][] = new boolean[8][8][9];
        q.add(7);
        q.add(0);
        q.add(0);
        boolean ans = false;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            int t = q.remove();
            if (x == 0 && y == 7) ans = true;
            for (int k = 0; k < 9; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                int nt = Math.min(t + 1, 8);
                if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                    if (nx - t >= 0 && a[nx - t][ny] == '#') continue;
                    if (nx - t - 1 >= 0 && a[nx - t - 1][ny] == '#') continue;
                    if (check[nx][ny][nt] == false) {
                        check[nx][ny][nt] = true;
                        q.add(nx);
                        q.add(ny);
                        q.add(nt);
                    }
                }
            }
        }
        System.out.println(ans ? 1 : 0);
    }
}

//another way to solve
/*
import java.util.*;
public class B16954 {
    final static int[] dx = {0,0,1,-1,1,-1,1,-1,0};
    final static int[] dy = {1,-1,0,0,1,1,-1,-1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 8;
        String[] a = new String[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.next();
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[][][] check = new boolean[8][8][9];
        check[7][0][0] = true;
        q.add(7); q.add(0); q.add(0);
        boolean ans = false;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            int t = q.remove();
            if (x == 0 && y == 7) ans = true;
            for (int k=0; k<9; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                int nt = Math.min(t+1, 8);
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (nx-t >= 0 && a[nx-t].charAt(ny) == '#') continue;
                    if (nx-t-1 >= 0 && a[nx-t-1].charAt(ny) == '#') continue;
                    if (check[nx][ny][nt] == false) {
                        check[nx][ny][nt] = true;
                        q.add(nx); q.add(ny); q.add(nt);
                    }
                }
            }
        }
        System.out.println(ans ? 1 : 0);
    }
}
*/

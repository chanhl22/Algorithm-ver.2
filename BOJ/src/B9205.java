//playtime = 01:11:33

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B9205 {
    static ArrayList<int[]> point;
    static int n, sx, sy, ex, ey;

    static boolean bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy});
        boolean[] check = new boolean[n + 2];
        check[0] = true;
        while (!q.isEmpty()) {
            int[] next = q.remove();
            int x = next[0];
            int y = next[1];
            if (Math.abs(x - ex) + Math.abs(y - ey) <= 1000) {
                return true;
            }
            for (int i = 0; i < n + 2; i++) {
                if (check[i] == false) {
                    int nx = point.get(i)[0];
                    int ny = point.get(i)[1];
                    int d = Math.abs(x - nx) + Math.abs(y - ny);
                    if (d <= 1000) {
                        check[i] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            point = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                if (i == 0) {
                    sx = x;
                    sy = y;
                } else if (i == n + 1) {
                    ex = x;
                    ey = y;
                }
                point.add(new int[]{x, y});
            }
            if (bfs()) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }
}

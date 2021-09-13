import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Points{
    int rx;
    int ry;
    int bx;
    int by;

    public Points(int rx, int ry, int bx, int by) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
    }
}

public class B15653 {
    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.next().toCharArray();
        }
        // bfs init
        Queue<Points> q = new LinkedList<>();
        int rx = 0;
        int ry = 0;
        int bx = 0;
        int by = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (a[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }
        q.add(new Points(rx, ry, bx, by));
        while (!q.isEmpty()) {
            Points temp = q.remove();
            rx = temp.rx;
            ry = temp.ry;
            bx = temp.bx;
            by = temp.by;
            for (int i = 0; i < 4; i++) {

            }
        }
    }
}

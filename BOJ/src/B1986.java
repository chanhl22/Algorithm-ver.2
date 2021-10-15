import java.util.Scanner;

public class B1986 {
    static int[][] a;
    static int n;
    static int m;
    static int[] queen;
    static int[] knight;
    static int k1;
    static int k2;

    static void check_queen(int x, int y) {
        int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
        int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};

        for (int k = 0; k < 8; k++) {
            int nx = x;
            int ny = y;
            while (true) {
                nx += dx[k];
                ny += dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (a[nx][ny] == 1 || a[nx][ny] == 2 || a[nx][ny] == 3) break;
                    a[nx][ny] = 4;
                } else {
                    break;
                }
            }
        }
    }

    static void check_knight(int x, int y) {
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                a[nx][ny] = 4;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        k1 = sc.nextInt();
        queen = new int[k1 * 2];
        for (int j = 0; j < k1; j++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            queen[j * 2] = x;
            queen[j * 2 + 1] = y;
            a[x][y] = 1; // Queen
        }
        k2 = sc.nextInt();
        knight = new int[k2 * 2];
        for (int j = 0; j < k2; j++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            knight[j * 2] = x;
            knight[j * 2 + 1] = y;
            a[x][y] = 2; // Knight
        }
        int k3 = sc.nextInt();
        for (int j = 0; j < k3; j++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            a[x][y] = 3; // Pawn
        }
        for (int i = 0; i < queen.length; i += 2) {
            check_queen(queen[i], queen[i + 1]);
        }
        for (int i = 0; i < knight.length; i += 2) {
            check_knight(knight[i], knight[i + 1]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}

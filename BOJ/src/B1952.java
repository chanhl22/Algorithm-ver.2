import java.util.Scanner;

public class B1952 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        boolean[][] check = new boolean[n][m];
        int ans = 0;
        int dir = 0;
        int x = 0;
        int y = 0;
        while (true) {
            if (check[x][y] == true) {
                break;
            }
            check[x][y] = true;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || check[nx][ny] == true) {
                dir = (dir + 1) % 4;
                ans++;
            }
            x = x + dx[dir];
            y = y + dy[dir];
        }
        System.out.println(ans - 1);
    }
}

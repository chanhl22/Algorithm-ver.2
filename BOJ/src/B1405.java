//playtime = 01:11:34

import java.util.Scanner;

public class B1405 {
    static int n;
    static double ans = 0;
    static boolean[][] visited;
    static double[] percentage;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        percentage = new double[4];
        for (int i = 0; i < 4; i++) {
            percentage[i] = sc.nextInt() * 0.01;
        }
        visited = new boolean[50][50];
        visited[25][25] = true;
        dfs(0, 1, 25, 25);
        System.out.println(ans);
    }

    private static void dfs(int index, double sum, int sx, int sy) {
        if (index == n) {
            ans += sum;
            return;
        }
        for (int k = 0; k < 4; k++) {
            int nx = sx + dx[k];
            int ny = sy + dy[k];
            if (visited[nx][ny] == false) {
                visited[nx][ny] = true;
                dfs(index + 1, sum * percentage[k], nx, ny);
                visited[nx][ny] = false;
            }
        }
    }
}

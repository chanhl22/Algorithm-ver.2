//playtime = 16:13

import java.util.Scanner;

public class B1238 {
    static int INF = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = INF;
            }
        }
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            dist[start][end] = sc.nextInt();
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (i == x) continue;
            if (dist[i][x] + dist[x][i] > answer) {
                answer = dist[i][x] + dist[x][i];
            }

        }
        System.out.println(answer);
    }
}

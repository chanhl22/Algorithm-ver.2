//playtime = 46:19

import java.util.Scanner;

public class B1956 {
    static int v;
    static int e;
    static int[][] dist;
    static final int INF = 10000000;

    public static void main(String[] args) {
        input();
        floydWarshall();
        calcMinCycle();
    }

    private static void calcMinCycle() {
        int answer = -1;
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (dist[i][j] != INF && dist[j][i] != INF) {
                    if (answer == -1 || dist[i][j] + dist[j][i] < answer) {
                        answer = dist[i][j] + dist[j][i];
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        dist = new int[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                dist[i][j] = INF;
            }
        }
        for (int i = 0; i < e; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            dist[start][end] = sc.nextInt();
        }
    }

    private static void floydWarshall() {
        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
}

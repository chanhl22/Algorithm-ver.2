//playtime = 04:07

import java.util.Scanner;

public class B2738 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];

        init(sc, n, m, a, b);

        printAnswer(n, m, a, b);
    }

    private static void init(Scanner sc, int n, int m, int[][] a, int[][] b) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = sc.nextInt();
            }
        }
    }

    private static void printAnswer(int n, int m, int[][] a, int[][] b) {
        int[][] answer = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer[i][j] = a[i][j] + b[i][j];
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}

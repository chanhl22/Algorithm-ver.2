/**
 * palytime = 15:17
 */

import java.util.Scanner;

public class B2740 {
    private static int n;
    private static int m;
    private static int k;
    private static int[][] matrix1;
    private static int[][] matrix2;
    private static int[][] matrix3;

    public static void main(String[] args) {
        input();
        makeMatrix();
        answer();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        matrix1 = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }

        m = sc.nextInt();
        k = sc.nextInt();
        matrix2 = new int[m][k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }
    }

    private static void makeMatrix() {
        matrix3 = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                matrix3[i][j] = calculate(i, j);
            }
        }
    }

    private static void answer() {
        for (int[] ints : matrix3) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int calculate(int x, int y) {
        int result = 0;
        for (int i = 0; i < m; i++) {
            result += matrix1[x][i] * matrix2[i][y];
        }
        return result;
    }
}

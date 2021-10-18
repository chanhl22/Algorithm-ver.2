import java.util.Scanner;

public class B20205 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int[][] b = new int[n * k][n * k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = i * k; l < (i * k) + k; l++) {
                    for (int m = j * k; m < (j * k) + k; m++) {
                        b[l][m] = a[i][j];
                    }
                }

            }
        }
        for (int i = 0; i < n * k; i++) {
            for (int j = 0; j < n * k; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }
}

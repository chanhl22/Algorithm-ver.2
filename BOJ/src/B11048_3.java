import java.util.Scanner;

public class B11048_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int[][] d = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                d[i][j] = Math.max(d[i-1][j],d[i][j-1]);
                d[i][j] += a[i][j];
            }
        }
        System.out.println(d[n][m]);
    }
}

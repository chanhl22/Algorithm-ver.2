import java.util.Arrays;
import java.util.Scanner;

public class B1895 {
    static int n;
    static int m;
    static int[][] a;

    static int cal(int x, int y) {
        int[] arr = new int[9];
        int index = 0;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                arr[index] = a[i][j];
                index++;
            }
        }
        Arrays.sort(arr);
        return arr[4];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int t = sc.nextInt();
        int[][] b = new int[n - 2][m - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                b[i][j] = cal(i, j);
            }
        }
        int ans = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < m-2; j++) {
                if (t <= b[i][j]) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}

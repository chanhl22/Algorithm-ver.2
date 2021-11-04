import java.util.Arrays;
import java.util.Scanner;

public class B2476 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            if (a[i][0] == a[i][1] && a[i][1] == a[i][2]) {
                temp[i] = 10000 + (a[i][0] * 1000);
            } else if (a[i][0] == a[i][1] || a[i][0] == a[i][2]) {
                temp[i] = 1000 + (a[i][0] * 100);
            } else if (a[i][1] == a[i][2]) {
                temp[i] = 1000 + (a[i][1] * 100);
            } else {
                int max = Math.max(a[i][0], Math.max(a[i][1], a[i][2]));
                temp[i] = max * 100;
            }
        }
        Arrays.sort(temp);
        System.out.println(temp[n - 1]);
    }
}

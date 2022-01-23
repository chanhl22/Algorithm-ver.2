//playtime = 26:56

import java.util.Scanner;

public class B9455 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int result = 0;
            for (int j = 0; j < m; j++) {
                int cnt = 0;
                for (int i = 0; i < n; i++) {
                    if (arr[i][j] == 1) {
                        for (int k = i + 1; k < n; k++) {
                            if (arr[k][j] == 0) {
                                cnt++;
                            }
                        }
                    }
                }
                result += cnt;
            }
            System.out.println(result);
        }
    }
}

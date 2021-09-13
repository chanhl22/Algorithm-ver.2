import java.util.Scanner;

public class B5582 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int n = a.length();
        int m = b.length();
        a = " " + a;
        b = " " + b;
        int[][] d = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    d[i][j] = d[i - 1][j - 1] + 1;
                } else {
                    d[i][j] = 0;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (ans < d[i][j]) {
                    ans = d[i][j];
                }
            }
        }
        System.out.println(ans);
    }
}

import java.util.Scanner;

public class B2799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] a = new char[5 * n + 1][5 * m + 1];
        for (int i = 0; i < 5 * n + 1; i++) {
            a[i] = sc.next().toCharArray();
        }
        int[] ans = new int[5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int close = 0;
                for (int k = 5 * i + 1; k < 5 * i + 5; k++) {
                    for (int l = 5 * j + 1; l < 5 * j + 5; l++) {
                        if (a[k][l] == '*') {
                            close++;
                        }
                    }
                }
                if (close == 0) {
                    ans[0]++;
                } else if (close == 4) {
                    ans[1]++;
                } else if (close == 8) {
                    ans[2]++;
                } else if (close == 12) {
                    ans[3]++;
                } else if (close == 16) {
                    ans[4]++;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

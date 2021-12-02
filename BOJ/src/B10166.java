//playtime = 44:31

import java.util.Scanner;

public class B10166 {
    static int GCD(int a, int b) {
        while (b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d1 = sc.nextInt();
        int d2 = sc.nextInt();
        boolean[][] check = new boolean[2001][2001];
        int ans = 0;
        for (int i = d1; i <= d2; i++) {
            for (int j = 1; j <= i; j++) {
                int gcd = GCD(i, j);
                if (check[i/gcd][j/gcd]) {
                    continue;
                }
                ans++;
                check[i/gcd][j/gcd] = true;
            }
        }
        System.out.println(ans);
    }
}

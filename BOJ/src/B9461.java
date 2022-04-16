//playtime = 18:20

import java.util.Scanner;

public class B9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long[] s = new long[101];
        s[0] = 1;
        s[1] = 1;
        s[2] = 1;
        s[3] = 2;
        s[4] = 2;
        for (int i = 5; i <= 100; i++) {
            s[i] = s[i - 5] + s[i - 1];
        }
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(s[n - 1]);
        }
    }
}

//playtime = 36:00

import java.util.Scanner;

public class B2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = sc.nextInt();
        }
        int[] d = new int[n + 1];
        d[1] = s[1];
        if (n >= 2) {
            d[2] = s[1] + s[2];
        }
        for (int i = 3; i <= n; i++) {
            d[i] = s[i] + Math.max(d[i-2], d[i-3] + s[i-1]);
        }
        System.out.println(d[n]);
    }
}

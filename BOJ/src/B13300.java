//playtime = 08:28

import java.util.Scanner;

public class B13300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] m = new int[7];
        int[] w = new int[7];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int g = sc.nextInt();
            if (s == 0) {
                w[g]++;
            } else if (s == 1) {
                m[g]++;
            }
        }
        int ans = 0;
        for (int i = 1; i < 7; i++) {
            if (m[i] != 0) {
                if (m[i] % k == 0) {
                    ans += m[i] / k;
                } else {
                    ans += m[i] / k + 1;
                }
            }
            if (w[i] != 0) {
                if (w[i] % k == 0) {
                    ans += w[i] / k;
                } else {
                    ans += w[i] / k + 1;
                }
            }
        }
        System.out.println(ans);
    }
}

//playtime = 1:14:02

import java.util.Scanner;

public class B11564 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();
        long ans = 0;
        if (a < 0 && b > 0) {
            ans = Math.abs(a) / k + Math.abs(b) / k + 1;
        } else {
            if (Math.abs(a) > Math.abs(b)) {
                ans = Math.abs(Math.abs(a) / k - Math.abs(b) / k);
                if (b % k == 0) {
                    ans += 1;
                }
            } else {
                ans = Math.abs(Math.abs(b) / k - Math.abs(a) / k);
                if (a % k == 0) {
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }
}

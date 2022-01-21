//playtime = 07:07

import java.util.Scanner;

public class B1735 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();
        int ans1 = a1 * b2 + a2 * b1;
        int ans2 = b1 * b2;
        int g = gcd(ans1, ans2);
        ans1 /= g;
        ans2 /= g;
        System.out.println(ans1 + " " + ans2);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}

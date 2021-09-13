import java.util.Scanner;

public class B2702 {
    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static int lcm(int a, int b, int g) {
        int l = g * (a / g) * (b / g);
        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int GCD = gcd(a, b);
            int LCM = lcm(a, b, GCD);
            System.out.println(LCM + " " + GCD);
        }
    }
}

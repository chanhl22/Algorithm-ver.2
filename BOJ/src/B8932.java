import java.util.Scanner;

public class B8932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int ans = 0;
            int a = sc.nextInt();
            ans += 9.23076 * Math.pow(26.7 - a, 1.835);
            int b = sc.nextInt();
            ans += 1.84523 * Math.pow(b - 75, 1.348);
            int c = sc.nextInt();
            ans += 56.0211 * Math.pow(c - 1.5, 1.05);
            int d = sc.nextInt();
            ans += 4.99087 * Math.pow(42.5 - d, 1.81);
            int e = sc.nextInt();
            ans += 0.188807 * Math.pow(e - 210, 1.41);
            int f = sc.nextInt();
            ans += 15.9803 * Math.pow(f - 3.8, 1.04);
            int g = sc.nextInt();
            ans += 0.11193 * Math.pow(254 - g, 1.88);
            System.out.println(ans);
        }
    }
}

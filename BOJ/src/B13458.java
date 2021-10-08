import java.util.Scanner;

public class B13458 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int b = sc.nextInt();
        int c = sc.nextInt();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] - b <= 0) {
                ans += 1;
            } else {
                ans += 1;
                if ((a[i] - b) % c == 0) {
                    ans += (a[i] - b) / c;
                } else {
                    ans += (a[i] - b) / c + 1;
                }
            }
        }
        System.out.println(ans);
    }
}

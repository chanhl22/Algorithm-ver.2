import java.util.Scanner;

public class B6359 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i * j <= n) {
                        if (a[i * j] == 0) {
                            a[i * j] = 1;
                        } else {
                            a[i * j] = 0;
                        }
                    }
                }
            }
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (a[i] == 1) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}

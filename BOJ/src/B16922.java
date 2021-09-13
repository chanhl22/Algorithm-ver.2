import java.util.Scanner;

public class B16922 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] check = new boolean[50 * 20 + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                for (int k = 0; k <= n - i - j; k++) {
                    int l = n - i - j - k;
                    int sum = i * 1 + j * 5 + k * 10 + l * 50;
                    check[sum] = true;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= 1000; i++) {
            if (check[i]) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}

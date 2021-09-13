import java.util.Scanner;

public class B1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        if (n > 0 && n < 10) {
            for (int i = 1; i <= n; i++) {
                ans++;
            }
        } else if (n >= 10 && n < 100) {
            for (int i = 1; i <= n; i++) {
                ans++;
            }
        } else if (n >= 100 && n <= 1000) {
            for (int i = 1; i < 100; i++) {
                ans++;
            }
            for (int i = 100; i <= n; i++) {
                int temp1 = i / 100;
                int temp2 = (i / 10) % 10;
                int temp3 = i % 10;
                if (temp1 - temp2 == temp2 - temp3) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}

//playtime = 27:00

import java.util.Scanner;

public class B3474 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int count = 0;
            int n = sc.nextInt();
            for (int i = 5; i <= n; i *= 5) {
                count += n / i;
            }
            System.out.println(count);
        }
    }
}

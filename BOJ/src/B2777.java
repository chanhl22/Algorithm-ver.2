/**
 * playtime = 01:16:11
 */

import java.util.Scanner;

public class B2777 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            if (n < 10) {
                System.out.println("1");
                continue;
            }

            int count = 0;
            for (int i = 9; i >= 2; i--) {
                while (n % i == 0) {
                    n = n / i;
                    count++;
                }
            }
            System.out.println(n == 1 ? count : -1);
        }
    }
}

/**
 * playtime = 16:42
 */

import java.util.Scanner;

public class B10214 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int y = 0;
            int k = 0;
            for (int i = 0; i < 9; i++) {
                y += sc.nextInt();
                k += sc.nextInt();
            }
            if (y == k) {
                System.out.println("Draw");
            } else if (y > k) {
                System.out.println("Yonsei");
            } else {
                System.out.println("Korea");
            }
        }
    }
}

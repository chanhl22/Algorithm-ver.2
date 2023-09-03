/**
 * playtime = 05:54
 */

import java.util.Scanner;

public class B10810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] basket = new int[n];
        for (int count = 0; count < m; count++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();
            for (int l = i; l <= j; l++) {
                basket[l - 1] = k;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(basket[i] + " ");
        }
    }
}

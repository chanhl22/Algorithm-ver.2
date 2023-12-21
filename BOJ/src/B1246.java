/**
 * playtime = 19m 05s
 */

import java.util.Arrays;
import java.util.Scanner;

public class B1246 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] price = new int[m];
        for (int i = 0; i < m; i++) {
            price[i] = sc.nextInt();
        }
        Arrays.sort(price);

        int max = 0;
        int record = 0;

        for (int i = m - 1; i >= 0; i--) {
            int standard = price[i];
            int sum = 0;
            int aggCount = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (price[j] >= standard && aggCount < n) {
                    sum += standard;
                    aggCount++;
                } else {
                    break;
                }
            }
            if (sum > max) {
                max = sum;
                record = standard;
            }
        }

        System.out.println(record + " " + max);
    }
}
/**
 * playtime = 11:52
 */

import java.util.Scanner;

public class B23971 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt() + 1;
        int m = sc.nextInt() + 1;

        int count = 0;
        for (int i = 0; i < h; i += n) {
            for (int j = 0; j < w; j += m) {
                count++;
            }
        }

        System.out.println(count);
    }
}

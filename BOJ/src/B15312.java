/**
 * playtime = 21:54
 */

import java.util.Scanner;

public class B15312 {
    private static final int[] alphaCount = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int total = a.length() + b.length();
        int[] result = new int[total];
        for (int i = 0, j = 0; i < total; i += 2, j++) {
            result[i] = a.charAt(j) - 'A';
        }
        for (int i = 1, j = 0; i < total; i += 2, j++) {
            result[i] = b.charAt(j) - 'A';
        }

        int[] count = new int[total];
        for (int i = 0; i < total; i++) {
            count[i] = alphaCount[result[i]];
        }

        int loop = total;
        while (loop != 2) {
            for (int i = 0; i < total - 1; i++) {
                count[i] = (count[i] + count[i + 1]) % 10;
            }
            loop--;
        }

        System.out.println(count[0] + "" + count[1]);
    }
}

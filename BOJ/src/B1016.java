/**
 * playtime = 01:10:05
 * 다시 풀라해도 못 풀듯..
 */

import java.util.Scanner;

public class B1016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();

        long total = max - min + 1;
        long sqrt = (long) Math.sqrt(max);

        boolean[] check = new boolean[(int) total];

        for (long i = 2; i <= sqrt; i++) {
            long start = min % (i * i) == 0 ? min / (i * i) : min / (i * i) + 1;
            for (long j = start; j * i * i <= max; j++) {
                check[(int) (j * i * i - min)] = true;
            }
        }

        int result = 0;
        for (boolean b : check) {
            if (!b) {
                result++;
            }
        }
        System.out.println(result);
    }
}

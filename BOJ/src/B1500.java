/**
 * playtime = 20:02
 */

import java.util.Scanner;

public class B1500 {
    private static int s;
    private static int k;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        s = sc.nextInt();
        k = sc.nextInt();
    }

    private static void solution() {
        long[] number = new long[k];
        for (int i = 0; i < k; i++) {
            number[i] = s / k;
        }

        int temp = s % k;
        for (int i = 0; i < temp; i++) {
            number[i]++;
        }

        long result = 1;
        for (int i = 0; i < k; i++) {
            result *= number[i];
        }
        System.out.println(result);
    }
}

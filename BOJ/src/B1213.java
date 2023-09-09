/**
 * playtime = 32:25
 */

import java.util.Scanner;

public class B1213 {

    private static int[] alpha;

    public static void main(String[] args) {
        input();
        if (findOdd()) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            makeAlpha();
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        alpha = new int[26];
        for (int i = 0; i < input.length(); i++) {
            alpha[input.charAt(i) - 'A']++;
        }
    }

    private static boolean findOdd() {
        int count = 0;
        for (int c : alpha) {
            if (c % 2 != 0) {
                count++;
            }
        }
        return count >= 2;
    }

    private static void makeAlpha() {
        StringBuilder sb = new StringBuilder();
        int center = -1;
        for (int i = 0; i < alpha.length; i++) {
            int write = alpha[i] / 2;
            if (alpha[i] % 2 != 0) {
                center = i;
            }
            for (int j = 0; j < write; j++) {
                sb.append((char) (i + 'A'));
                alpha[i]--;
            }
        }

        if (center != -1) {
            sb.append((char) (center + 'A'));
            alpha[center]--;
        }

        for (int i = alpha.length - 1; i >= 0; i--) {
            for (int j = 0; j < alpha[i]; j++) {
                sb.append((char) (i + 'A'));
            }
        }

        System.out.println(sb);
    }
}

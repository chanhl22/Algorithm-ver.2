/**
 * playtime = 09:52
 */

import java.util.Scanner;

public class B11637 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] score = new int[n];
            int total = 0;
            int max = 0;
            int winner = -1;
            for (int i = 0; i < n; i++) {
                score[i] = sc.nextInt();
                total += score[i];
                if (score[i] > max) {
                    max = score[i];
                    winner = i;
                }
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (score[i] == max) {
                    count++;
                }
            }
            if (count > 1) {
                System.out.println("no winner");
            } else if (total / 2 < max) {
                System.out.println("majority winner " + (winner + 1));
            } else {
                System.out.println("minority winner " + (winner + 1));
            }
        }
    }
}

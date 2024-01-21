/**
 * playtime = 09m 33s
 */

import java.util.Scanner;

public class B27736 {

    private static int n;
    private static int[] result;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void solution() {
        int agreement = 0;
        int opposition = 0;
        int abstention = 0;
        for (int i = 0; i < n; i++) {
            if (result[i] == 1) {
                agreement++;
            } else if (result[i] == -1) {
                opposition++;
            } else {
                abstention++;
            }
        }

        if (n % 2 == 0) {
            if (n / 2 <= abstention) {
                System.out.println("INVALID");
                System.exit(0);
            }
        } else {
            if (n / 2 + 1 <= abstention) {
                System.out.println("INVALID");
                System.exit(0);
            }
        }

        if (agreement > opposition) {
            System.out.println("APPROVED");
        } else {
            System.out.println("REJECTED");
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = sc.nextInt();
        }
    }
}

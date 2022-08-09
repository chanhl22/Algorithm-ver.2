//playtime = 14:00

import java.util.Scanner;

public class B9020 {

    static final int MAX = 10001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] prime = getPrime();

        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            findAnswer(n, prime);
            System.out.println();
        }
    }

    private static boolean[] getPrime() {
        boolean[] prime = new boolean[MAX];
        for (int i = 2; i < MAX; i++) {
            if (!prime[i]) {
                for (int j = i * i; j < MAX; j += i) {
                    prime[j] = true;
                }
            }
        }
        return prime;
    }

    private static void findAnswer(int n, boolean[] prime) {
        for (int i = n / 2; i >= 2; i--) {
            if (!prime[i] && !prime[n - i]) {
                System.out.print(i + " " + (n - i));
                break;
            }
        }
    }
}

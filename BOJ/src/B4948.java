//playtime = 15:26

import java.util.Scanner;

public class B4948 {
    static final int MAX = 123456 * 2 + 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] prime = new boolean[MAX];
        for (int i = 2; i < MAX; i++) {
            if (!prime[i]) {
                for (int j = i + i; j < MAX; j += i) {
                    prime[j] = true;
                }
            }
        }
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int ans = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (!prime[i]) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}

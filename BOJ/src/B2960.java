//playtime = 18:00

import java.util.Scanner;

public class B2960 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean[] prime = new boolean[n + 1];
        for (int i = 2; i < n + 1; i++) {
            if (prime[i] == false) {
                for (int j = i; j < n + 1; j += i) {
                    if (prime[j] != true) {
                        prime[j] = true;
                        k--;
                        if (k == 0) {
                            System.out.println(j);
                            return;
                        }
                    }
                }
            }
        }
    }
}

/**
 * playtime = 36:51
 */

import java.util.ArrayList;
import java.util.Scanner;

public class B15711 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> prime = new ArrayList<>();
        boolean[] isPrime = new boolean[2000000];

        for (int i = 2; i < 2000000; i++) {
            if (!isPrime[i]) {
                for (int j = i + i; j < 2000000; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        for (int i = 2; i < 2000000; i++) {
            if (!isPrime[i]) {
                prime.add(i);
            }
        }

        int t = sc.nextInt();
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();

            long sum = a + b;

            if (sum == 2 || sum == 3) {
                System.out.println("NO");
            } else if (sum % 2 == 0) {
                System.out.println("YES");
            } else {
                sum -= 2;
                boolean canCut = false;
                for (int i = 0; i < prime.size(); i++) {
                    if (sum != prime.get(i) && sum % prime.get(i) == 0) {
                        System.out.println("NO");
                        canCut = true;
                        break;
                    }
                }
                if (!canCut) {
                    System.out.println("YES");
                }
            }
        }
    }
}
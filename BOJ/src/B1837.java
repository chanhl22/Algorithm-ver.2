//playtime : 30:48

import java.math.BigInteger;
import java.util.Scanner;

public class B1837 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bn = sc.next();
        BigInteger n = new BigInteger(bn);
        int k = sc.nextInt();
        boolean[] prime = new boolean[k];
        for (int i = 2; i < k; i++) {
            if (prime[i] == false) {
                for (int j = i + i; j < k; j += i) {
                    prime[j] = true;
                }
            }
        }
        boolean ok = false;
        int num = 0;
        for (int i = 2; i < k; i++) {
            if (prime[i] == false) {
                if (n.remainder(BigInteger.valueOf(i)).equals(BigInteger.valueOf(0))) {
                    ok = true;
                    num = i;
                    break;
                }
            }
        }
        if (ok) {
            System.out.println("BAD" + " " + num);
        } else {
            System.out.println("GOOD");
        }
    }
}

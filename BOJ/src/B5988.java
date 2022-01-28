//playtime = 03:55

import java.math.BigInteger;
import java.util.Scanner;

public class B5988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            BigInteger bigInteger = new BigInteger(str);
            if (bigInteger.remainder(new BigInteger("2")).intValue() == 0) {
                System.out.println("even");
            } else {
                System.out.println("odd");
            }
        }
    }
}

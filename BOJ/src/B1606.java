/**
 * playtime = 02h 17m 30s
 */

import java.math.BigInteger;
import java.util.Scanner;

public class B1606 {

    private static long x;
    private static long y;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void solution() {
        BigInteger positionX = calX();
        BigInteger positionY = calY(positionX);
        System.out.println(positionY);
    }

    private static BigInteger calX() {
        long moveX;
        if (y == 0) {
            moveX = x;
        } else {
            moveX = x + y - 1;
        }

        BigInteger monkeyX = BigInteger.valueOf(1);
        for (long i = 1; i <= moveX; i++) {
            long l = 6 * i;
            BigInteger bigInteger = BigInteger.valueOf(l);
            monkeyX = monkeyX.add(bigInteger);
        }

        return monkeyX;
    }

    private static BigInteger calY(BigInteger positionX) {
        return positionX.add(BigInteger.valueOf(y));
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        x = sc.nextLong();
        y = sc.nextLong();
    }
}

/**
 * 1 (0,0) 2 (0,1)
 * 7 (1,0) 8 (1,1) 9 (0,2)
 * 19 (2,0) 20(2,1) 21(1,2) 22(0,3)
 * 37 (3,0) 38(3,1) 39(2,2) 40(1,3) 41(0,4)
 * 61 (4,0) 62(4,1) 63(3,2) 64(2,3) 65(1,4) 66(0,5)
 */
/**
 * playtime = 11:00
 */

import java.util.Scanner;

public class B15953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int reward = 0;
            reward += a == 0 ? 0 : check2017(a);
            reward += b == 0 ? 0 : check2018(b);
            System.out.println(reward);
        }
    }

    private static int check2017(int a) {
        if (a > 21) {
            return 0;
        }
        if (a <= 1) {
            return 5000000;
        } else if (a <= 3) {
            return 3000000;
        } else if (a <= 6) {
            return 2000000;
        } else if (a <= 10) {
            return 500000;
        } else if (a <= 15) {
            return 300000;
        } else {
            return 100000;
        }
    }

    private static int check2018(int b) {
        if (b > 31) {
            return 0;
        }
        if (b <= 1) {
            return 5120000;
        } else if (b <= 3) {
            return 2560000;
        } else if (b <= 7) {
            return 1280000;
        } else if (b <= 15) {
            return 640000;
        } else {
            return 320000;
        }
    }
}

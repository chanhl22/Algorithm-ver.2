//playtime = 11:31

import java.util.Scanner;

public class B1598 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() - 1;
        int m = sc.nextInt() - 1;
        int x1 = n % 4;
        int y1 = n / 4;
        int x2 = m % 4;
        int y2 = m / 4;
        int ret1 = Math.abs(x1 - x2);
        int ret2 = Math.abs(y1 - y2);
        System.out.println(ret1 + ret2);
    }
}

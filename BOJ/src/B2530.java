/**
 * playtime = 07:59
 */

import java.util.Scanner;

public class B2530 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        int need = sc.nextInt();

        int now = h * 60 * 60 + m * 60 + s;
        int result = now + need;

        int nh = result / 3600;
        int remain = result % 3600;
        int nm = remain / 60;
        int ns = remain % 60;

        System.out.println(nh % 24 + " " + nm + " " + ns);
    }
}

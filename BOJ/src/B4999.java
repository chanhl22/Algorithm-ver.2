/**
 * playtime = 03:07
 */

import java.util.Scanner;

public class B4999 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String me = sc.next();
        String doctor = sc.next();

        if (me.length() < doctor.length()) {
            System.out.println("no");
        } else {
            System.out.println("go");
        }
    }
}

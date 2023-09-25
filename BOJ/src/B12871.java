/**
 * playtime = 20:51
 */

import java.util.Scanner;

public class B12871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();

        StringBuilder ss = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            ss.append(s);
        }

        StringBuilder tt = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            tt.append(t);
        }

        if (ss.toString().equals(tt.toString())) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}

/**
 * playtime = 13:25
 */

import java.util.Scanner;

public class B2935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String operator = sc.next();
        String b = sc.next();

        if (operator.equals("*")) {
            int len = b.length() - 1;
            StringBuilder zero = new StringBuilder();
            for (int i = 0; i < len; i++) {
                zero.append(0);
            }
            System.out.println(a + zero);
        } else {
            StringBuilder result = new StringBuilder();
            if (a.length() > b.length()) {
                for (int i = 0; i < a.length() - b.length(); i++) {
                    result.append(a.charAt(i));
                }
                result.append(b);
            } else if (a.length() == b.length()) {
                result.append(2);
                for (int i = 0; i < a.length() - 1; i++) {
                    result.append(0);
                }
            } else {
                for (int i = 0; i < b.length() - a.length(); i++) {
                    result.append(b.charAt(i));
                }
                result.append(a);
            }
            System.out.println(result);
        }
    }
}

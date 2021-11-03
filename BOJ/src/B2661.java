//time = 1:03:07

import java.util.Scanner;

public class B2661 {

    static void go(String ans, int n) {
        if (ans.length() == n) {
            System.out.println(ans);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            String temp = ans + i;
            if (check(temp)) {
                go(temp, n);
            }
        }
    }

    static boolean check(String str) {
        int len = str.length() / 2;
        for (int i = 1; i <= len; i++) {
            String front = str.substring(str.length() - i * 2, str.length() - i);
            String back = str.substring(str.length() - i, str.length());
            if (back.equals(front)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        go("", n);
    }
}

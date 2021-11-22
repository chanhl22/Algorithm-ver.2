//playtime = 04:51

import java.util.Scanner;

public class B12904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        int n = s.length();
        int m = t.length();
        StringBuilder sb = new StringBuilder(t);
        boolean ok = false;
        for (int i = m - 1; i > 0; i--) {
            if (sb.charAt(i) == 'A') {
                sb.deleteCharAt(i);
            } else if (sb.charAt(i) == 'B') {
                sb.deleteCharAt(i);
                sb.reverse();
            }
            if (s.equals(sb.toString())) {
                ok = true;
            }
        }
        System.out.println(ok == true ? 1 : 0);
    }
}

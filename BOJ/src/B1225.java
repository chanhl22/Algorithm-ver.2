//playtime = 08:01

import java.util.Scanner;

public class B1225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        String m = sc.next();
        long ans = 0;
        int nLen = n.length();
        int mLen = m.length();
        for (int i = 0; i < nLen; i++) {
            for (int j = 0; j < mLen; j++) {
                long temp1 = n.charAt(i) - '0';
                long temp2 = m.charAt(j) - '0';
                ans += temp1 * temp2;
            }
        }
        System.out.println(ans);
    }
}

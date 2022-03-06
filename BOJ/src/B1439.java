//playtime = 09:13

import java.util.Scanner;

public class B1439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int check1 = 0;
        int check2 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i > 0 && str.charAt(i) == str.charAt(i - 1)) continue;
            if (str.charAt(i) == '0') {
                check1++;
            } else {
                check2++;
            }
        }
        System.out.println(check1 > check2 ? check2 : check1);
    }
}

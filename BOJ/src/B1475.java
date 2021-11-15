//playtime = 10:41

import java.util.Scanner;

public class B1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] a = new int[10];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) - '0' == 6 || str.charAt(i) - '0' == 9) {
                if (a[6] > a[9]) {
                    a[9]++;
                } else {
                    a[6]++;
                }
            } else {
                a[str.charAt(i) - '0']++;
            }
        }
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            if (cnt < a[i]) {
                cnt = a[i];
            }
        }
        System.out.println(cnt);
    }
}

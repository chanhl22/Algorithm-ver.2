//playtime = 05:14

import java.util.Scanner;

public class B15734 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        int a = sc.nextInt();
        while (a-- > 0) {
            if (l < r) {
                l++;
            } else {
                r++;
            }
        }
        System.out.println(Math.min(l, r) * 2);
    }
}

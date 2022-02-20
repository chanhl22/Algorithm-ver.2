//playtime = 10:11

import java.util.Scanner;

public class B1267 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k;
        int y = 0, m = 0;
        for (int i = 0; i < n; i++) {
            k = sc.nextInt();
            y += ((k / 30) + 1) * 10;
            m += ((k / 60) + 1) * 15;
        }
        if (y == m) {
            System.out.println("Y M " + y);
        } else if (y < m) {
            System.out.println("Y " + y);
        } else if (y > m) {
            System.out.println("M " + m);
        }
    }
}


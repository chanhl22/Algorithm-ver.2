//playtime = 03:09

import java.util.Scanner;

public class B2720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int num = sc.nextInt();
            int[] a = new int[4];
            while (num / 25 > 0) {
                num -= 25;
                a[0]++;
            }
            while (num / 10 > 0) {
                num -= 10;
                a[1]++;
            }
            while (num / 5 > 0) {
                num -= 5;
                a[2]++;
            }
            while (num / 1 > 0) {
                num -= 1;
                a[3]++;
            }
            for (int i = 0; i < 4; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
}

//playtime = 25:53

import java.util.Scanner;

public class B2896 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int i = sc.nextInt();
        int j = sc.nextInt();
        int k = sc.nextInt();
        double num1 = (double) a / i;
        double num2 = (double) b / j;
        double num3 = (double) c / k;
        double m = Math.min(num1, Math.min(num2, num3));
        if (a - i * m <= 0) {
            System.out.print(0 + " ");
        } else {
            System.out.print((a - i * m) + " ");
        }
        if (b - j * m <= 0) {
            System.out.print(0 + " ");
        } else {
            System.out.print((b - j * m) + " ");
        }
        if (c - k * m <= 0) {
            System.out.print(0 + " ");
        } else {
            System.out.print((c - k * m) + " ");
        }
    }
}

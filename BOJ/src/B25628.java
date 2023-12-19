/**
 * playtime = 03m 11s
 */

import java.util.Scanner;

public class B25628 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int bread = a / 2;
        System.out.println(Math.min(bread, b));
    }
}

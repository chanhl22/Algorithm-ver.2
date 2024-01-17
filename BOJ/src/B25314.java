/**
 * playtime = 02m 31s
 */

import java.util.Scanner;

public class B25314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int iter = (n - 4) / 4;
        for (int i = 0; i < iter; i++) {
            System.out.print("long ");
        }
        System.out.println("long int");
    }
}

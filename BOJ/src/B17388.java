//playtime = 2:40

import java.util.Scanner;

public class B17388 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (a + b + c >= 100) {
            System.out.println("OK");
        } else {
            int min = Math.min(a, Math.min(b, c));
            if (min == a) {
                System.out.println("Soongsil");
            } else if (min == b) {
                System.out.println("Korea");
            } else {
                System.out.println("Hanyang");
            }
        }
    }
}

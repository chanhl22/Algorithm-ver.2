/**
 * playtime = 06:15
 */

import java.util.Scanner;

class B5073 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();

            if (finish(n1, n2, n3)) {
                break;
            }

            if (isInvalid(n1, n2, n3)) {
                System.out.println("Invalid");
                continue;
            }

            if (isEquilateral(n1, n2, n3)) {
                System.out.println("Equilateral");
                continue;
            }

            if (isIsosceles(n1, n2, n3)) {
                System.out.println("Isosceles");
                continue;
            }

            if (isScalene(n1, n2, n3)) {
                System.out.println("Scalene");
            }
        }
    }

    private static boolean isInvalid(int n1, int n2, int n3) {
        if (n1 > n2 && n1 > n3) {
            return n1 >= n2 + n3;
        }
        if (n2 > n1 && n2 > n3) {
            return n2 >= n1 + n3;
        }
        if (n3 > n1 && n3 > n2) {
            return n3 >= n1 + n2;
        }
        return false;
    }

    private static boolean isScalene(int n1, int n2, int n3) {
        return n1 != n2 && n2 != n3;
    }

    private static boolean isIsosceles(int n1, int n2, int n3) {
        return n1 == n2 || n2 == n3 || n1 == n3;
    }

    private static boolean isEquilateral(int n1, int n2, int n3) {
        return n1 == n2 && n2 == n3;
    }


    private static boolean finish(int n1, int n2, int n3) {
        return n1 == 0 && n2 == 0 && n3 == 0;
    }
}
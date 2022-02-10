//playtime = 20:31

import java.util.Scanner;

public class B14696 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int a_cnt = sc.nextInt();
            int[] a = new int[a_cnt];
            for (int i = 0; i < a_cnt; i++) {
                a[i] = sc.nextInt();
            }
            int b_cnt = sc.nextInt();
            int[] b = new int[b_cnt];
            for (int i = 0; i < b_cnt; i++) {
                b[i] = sc.nextInt();
            }
            check(a, b);
        }
    }

    private static void check(int[] a, int[] b) {
        int a_star = 0;
        int a_circle = 0;
        int a_square = 0;
        int a_triangle = 0;
        int b_star = 0;
        int b_circle = 0;
        int b_square = 0;
        int b_triangle = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                a_triangle++;
            } else if (a[i] == 2) {
                a_square++;
            } else if (a[i] == 3) {
                a_circle++;
            } else {
                a_star++;
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i] == 1) {
                b_triangle++;
            } else if (b[i] == 2) {
                b_square++;
            } else if (b[i] == 3) {
                b_circle++;
            } else {
                b_star++;
            }
        }
        if (a_star > b_star) {
            System.out.println("A");
        } else if (a_star < b_star) {
            System.out.println("B");
        } else {
            if (a_circle > b_circle) {
                System.out.println("A");
            } else if (a_circle < b_circle) {
                System.out.println("B");
            } else {
                if (a_square > b_square) {
                    System.out.println("A");
                } else if (a_square < b_square) {
                    System.out.println("B");
                } else {
                    if (a_triangle > b_triangle) {
                        System.out.println("A");
                    } else if (a_triangle < b_triangle) {
                        System.out.println("B");
                    } else {
                        System.out.println("D");
                    }
                }
            }
        }
    }
}

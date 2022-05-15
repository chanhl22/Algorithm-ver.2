//playtime = 16:35

import java.util.Scanner;

public class B2446 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int space = 0;
        for (int i = n; i > 0; i--) {
            drawStar(n, space);
            space++;
            System.out.println();
        }
        space -= 2;
        for (int i = 1; i < n; i++) {
            drawStar(n, space);
            space--;
            System.out.println();
        }
    }

    private static void drawStar(int n, int space) {
        for (int j = 0; j < space; j++) {
            System.out.print(" ");
        }
        for (int j = 1; j < 2 * n - space * 2; j++) {
            System.out.print("*");
        }
    }
}

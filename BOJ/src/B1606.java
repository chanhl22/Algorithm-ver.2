/**
 * 01:33:20
 * 시간초과 못품
 */

import java.util.Scanner;

public class B1606 {

    private static int x;
    private static int y;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void solution() {
        int index = 1;
        for (int i = 0; i <= 1000000; i++) {
            find(i, 0, index);
            for (int j = 1, nx = i, ny = 1; j < i + 2; j++, nx--, ny++) {
                find(nx, ny, index + j);
            }
            index += 6 * (i + 1);
        }
    }

    private static void find(int currentX, int currentY, int index) {
        if (currentX == x && currentY == y) {
            System.out.println(index);
            System.exit(0);
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
    }
}

/**
 * 1 (0,0) 2 (0,1)
 * 7 (1,0) 8 (1,1) 9 (0,2)
 * 19 (2,0) 20(2,1) 21(1,2) 22(0,3)
 * 37 (3,0) 38(3,1) 39(2,2) 40(1,3) 41(0,4)
 * 61
 */
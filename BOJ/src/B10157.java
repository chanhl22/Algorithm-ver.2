/**
 * playtime = 01:27:12
 * 출력초과
 */

import java.util.Scanner;

public class B10157 {

    private static int c;
    private static int r;
    private static int find;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt(); //column
        r = sc.nextInt(); //row
        find = sc.nextInt();

        int row = r;
        int column = c;
        int storage = 1;
        int index = 0;
        while (!isEmpty(row, column)) {
            findPosition(index, row, column, storage);
            storage += row * 2 + column * 2 - 4;
            row -= 2;
            column -= 2;
            index++;
        }
        System.out.println(0);
    }

    private static void findPosition(int index, int row, int column, int storage) {

        System.out.println("index = " + index + ", row = " + row + ", column = " + column + ", storage = " + storage);

        int startX1 = index;
        int startY1 = index;
        int startX2 = index;
        int startY2 = index + row - 1;
        int startX3 = index + column - 1;
        int startY3 = index + row - 1;
        int startX4 = index + column - 1;
        int startY4 = index;

        for (int j = startY1; j < startY2; j++) {
            if (storage == find) {
                System.out.println((startX1 + 1) + " " + (j + 1));
                System.exit(0);
            }
            storage++;
        }
        for (int i = startX2; i < startX3; i++) {
            if (storage == find) {
                System.out.println((i + 1) + " " + (startY2 + 1));
                System.exit(0);
            }
            storage++;
        }
        for (int j = startY3; j > startY4; j--) {
            if (storage == find) {
                System.out.println((startX3 + 1) + " " + (j + 1));
                System.exit(0);
            }
            storage++;
        }
        for (int i = startX4; i > startX1; i--) {
            if (storage == find) {
                System.out.println((i + 1) + " " + (startY4 + 1));
                System.exit(0);
            }
            storage++;
        }
    }

    private static boolean isEmpty(int row, int column) {
        return row * 2 + column * 2 - 4 < 0;
    }
}
/**
 *  1  2  3  4  5  6
 * 22 23 24 25 26  7
 * 21 36 37 38 27  8
 * 20 35 42 39 28  9
 * 19 34 41 40 29 10
 * 18 33 32 31 30 11
 * 17 16 15 14 13 12
 * <p>
 * 1 ~ 22 = 22
 * 23 ~ 36 = 14
 * 37 ~ 42 = 6
 * <p>
 * 6 + 6 + 7 + 7 - 4 = 22
 * 4 + 4 + 5 + 5 - 4 = 14
 * 2 + 2 + 3 + 3 - 4 = 6
 * 0 + 0 + 1 + 1 - 4 = -2
 */
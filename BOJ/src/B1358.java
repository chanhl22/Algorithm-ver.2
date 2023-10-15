/**
 * playtime = 16:04
 */

import java.util.Scanner;

public class B1358 {

    private static int w;
    private static int h;
    private static int x;
    private static int y;
    private static int p;
    private static int[][] position;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void solution() {
        int count = 0;

        for (int i = 0; i < p; i++) {
            int nx = position[i][0];
            int ny = position[i][1];
            if (inSquare(nx, ny)) {
                count++;
                continue;
            }

            if (inRightCircle(nx, ny)) {
                count++;
                continue;
            }

            if (inLeftCircle(nx, ny)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean inSquare(int nx, int ny) {
        return nx >= x && nx <= x + w && ny >= y && ny <= y + h;
    }

    private static boolean inRightCircle(int nx, int ny) {
        int r = h / 2;
        return Math.pow(nx - (x + w), 2) + Math.pow(ny - (y + r), 2) <= Math.pow(r, 2);
    }

    private static boolean inLeftCircle(int nx, int ny) {
        int r = h / 2;
        return Math.pow(nx - x, 2) + Math.pow(ny - (y + r), 2) <= Math.pow(r, 2);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        w = sc.nextInt();
        h = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        p = sc.nextInt();
        position = new int[p][2];
        for (int i = 0; i < p; i++) {
            position[i][0] = sc.nextInt();
            position[i][1] = sc.nextInt();
        }
    }
}

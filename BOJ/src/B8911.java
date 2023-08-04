/**
 * playtime = 17:20
 */

import java.util.Scanner;

public class B8911 {
    private static int MAX_H;
    private static int MIN_H;
    private static int MAX_W;
    private static int MIN_W;
    private static int CURRENT_X;
    private static int CURRENT_Y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String path = sc.next();
            move(path);
            System.out.println(Math.abs(MAX_H - MIN_H) * Math.abs(MAX_W - MIN_W));
        }
    }

    /**
     * F: 한 눈금 앞으로
     * B: 한 눈금 뒤로
     * L: 왼쪽으로 90도 회전
     * R: 오른쪽으로 90도 회전
     */

    private static void move(String path) {
        MAX_H = 0;
        MAX_W = 0;
        MIN_H = 0;
        MIN_W = 0;
        CURRENT_X = 0;
        CURRENT_Y = 0;
        int dir = 1;
        for (int i = 0; i < path.length(); i++) {
            char character = path.charAt(i);
            if (character == 'F') {
                if (dir == 1) {
                    CURRENT_X++;
                } else if (dir == 3) {
                    CURRENT_X--;
                } else if (dir == 2) {
                    CURRENT_Y++;
                } else {
                    CURRENT_Y--;
                }
                update();
            } else if (character == 'B') {
                if (dir == 1) {
                    CURRENT_X--;
                } else if (dir == 3) {
                    CURRENT_X++;
                } else if (dir == 2) {
                    CURRENT_Y--;
                } else {
                    CURRENT_Y++;
                }
                update();
            } else if (character == 'L') {
                dir = (dir + 3) % 4;
            } else {
                dir = (dir + 1) % 4;
            }
        }
    }

    private static void update() {
        if (MAX_H < CURRENT_X) {
            MAX_H = CURRENT_X;
        }
        if (MIN_H > CURRENT_X) {
            MIN_H = CURRENT_X;
        }
        if (MAX_W < CURRENT_Y) {
            MAX_W = CURRENT_Y;
        }
        if (MIN_W > CURRENT_Y) {
            MIN_W = CURRENT_Y;
        }
    }
}

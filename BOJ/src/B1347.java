/**
 * playtime = 01:05:08
 */

import java.util.Scanner;

public class B1347 {
    private static int n;
    private static String input;
    /**
     * 상 - 0
     * 우 - 1
     * 하 - 2
     * 좌 - 3
     */
    private static final int[] dirX = {-1, 0, 1, 0};
    private static final int[] dirY = {0, 1, 0, -1};
    private static int currentDir = 2;
    private static int currentX = 51;
    private static int currentY = 51;
    private static int minX = 51;
    private static int maxX = 51;
    private static int minY = 51;
    private static int maxY = 51;
    private static final int[][] map = new int[103][103];

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        input = sc.next();
    }

    private static void solution() {
        map[currentX][currentY] = 1;
        for (int i = 0; i < input.length(); i++) {
            move(input.charAt(i));
        }
        calculate();
    }

    private static void calculate() {
        for (int i = 0; i < 103; i++) {
            for (int j = 0; j < 103; j++) {
                if (minX <= i && i <= maxX && minY <= j && j <= maxY) {
                    if (map[i][j] == 1) {
                        System.out.print(".");
                    } else {
                        System.out.print("#");
                    }
                    if (j == maxY) {
                        System.out.println();
                    }
                }
            }
        }
    }

    private static void move(char charAt) {
        if (charAt == 'L') {
            currentDir = (currentDir + 3) % 4;
        } else if (charAt == 'R') {
            currentDir = (currentDir + 1) % 4;
        } else {
            updateMapInfo();
        }
    }

    private static void updateMapInfo() {
        currentX = currentX + dirX[currentDir];
        currentY = currentY + dirY[currentDir];

        if (minX > currentX) {
            minX = currentX;
        }
        if (maxX < currentX) {
            maxX = currentX;
        }
        if (minY > currentY) {
            minY = currentY;
        }
        if (maxY < currentY) {
            maxY = currentY;
        }

        map[currentX][currentY] = 1;
    }
}

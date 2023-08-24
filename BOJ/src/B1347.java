/**
 * 40:19 안풀림;;
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
    private static final int[] dirX = {0, 1, 0, -1};
    private static final int[] dirY = {-1, 0, 1, 0};
    private static int currentDir = 2;
    private static int[][] map = new int[103][103];
    private static int startX = 51;
    private static int startY = 51;

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
        map[startX][startY] = 1;
        for (int i = 0; i < input.length(); i++) {
            move(input.charAt(i));
        }
        calculate();
    }

    private static void calculate() {
        int firstX = 0;
        int firstY = 0;
        int endX = 0;
        int endY = 0;
        boolean flag = true;
        for (int i = 0; i < 103; i++) {
            for (int j = 0; j < 103; j++) {
                if (flag && map[i][j] == 1) {
                    firstX = i;
                    firstY = j;
                    flag = false;
                }
                if (map[i][j] == 1) {
                    endX = i;
                    endY = j;
                }
            }
        }

        int mapFirstX = Math.min(firstX, endX);
        int mapEndX = Math.max(firstX, endX);
        int mapFirstY = Math.min(firstY, endY);
        int mapEndY = Math.max(firstY, endY);

        for (int i = 0; i < 103; i++) {
            boolean check = false;
            for (int j = 0; j < 103; j++) {
                if (mapFirstX <= i && i <= mapEndX && mapFirstY <= j && j <= mapEndY) {
                    check = true;
                    if (map[i][j] == 0) {
                        System.out.print("#");
                    } else {
                        System.out.print(".");
                    }
                }
            }
            if (check) {
                System.out.println();
            }
        }
    }

    private static void move(char charAt) {
        if (charAt == 'L') {
            currentDir = (currentDir + 3) % 4;
        } else if (charAt == 'R') {
            currentDir = (currentDir + 1) % 4;
        } else {
            map[startX + dirX[currentDir]][startY + dirY[currentDir]] = 1;
        }
    }
}

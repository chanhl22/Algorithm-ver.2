/**
 * playtime = 02:34:41
 * 못품
 */

import java.util.Scanner;

public class B2239 {

    private static int[][] map = new int[9][9];

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String str = sc.next();
            for (int j = 0; j < 9; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
    }

    private static void solution() {
        int repeat = 81;
        while (repeat-- > 0) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (map[i][j] == 0) {
                        updateMap(i, j);
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j] == 0) {
                    updatePossibleMinNumber(i, j);
                }
            }
        }

        print();
    }

    private static void updateMap(int x, int y) {
        boolean[] check = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (map[i][y] == 0) {
                continue;
            }
            check[map[i][y] - 1] = true;
        }
        for (int j = 0; j < 9; j++) {
            if (map[x][j] == 0) {
                continue;
            }
            check[map[x][j] - 1] = true;
        }
        int nx = x / 3 * 3;
        int ny = y / 3 * 3;
        for (int i = nx; i < nx + 3; i++) {
            for (int j = ny; j < ny + 3; j++) {
                if (map[i][j] == 0) {
                    continue;
                }
                check[map[i][j] - 1] = true;
            }
        }

        int count = 0;
        int temp = 0;
        for (int i = 0; i < 9; i++) {
            if (!check[i]) {
                count++;
                temp = i + 1;
            }
        }
        if (count == 1) {
            map[x][y] = temp;
        }
    }

    private static void updatePossibleMinNumber(int x, int y) {
        boolean[] check = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (map[i][y] == 0) {
                continue;
            }
            check[map[i][y] - 1] = true;
        }
        for (int j = 0; j < 9; j++) {
            if (map[x][j] == 0) {
                continue;
            }
            check[map[x][j] - 1] = true;
        }
        int nx = x / 3 * 3;
        int ny = y / 3 * 3;
        for (int i = nx; i < nx + 3; i++) {
            for (int j = ny; j < ny + 3; j++) {
                if (map[i][j] == 0) {
                    continue;
                }
                check[map[i][j] - 1] = true;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (!check[i]) {
                map[x][y] = i + 1;
                return;
            }
        }
    }

    private static void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}

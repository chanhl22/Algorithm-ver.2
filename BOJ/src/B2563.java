/**
 * playtime = 12:51
 */

import java.util.Scanner;

public class B2563 {
    private static final int LENGTH = 10;
    private static int PAPER_COUNT;
    private static int[][] PAPERS;
    private static int MAX_ROW;
    private static int MAX_COLUMN;


    public static void main(String[] args) {
        input();
        boolean[][] map = updateMap();
        answer(map);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        PAPER_COUNT = sc.nextInt();
        PAPERS = new int[PAPER_COUNT][2];
        MAX_ROW = 0;
        MAX_COLUMN = 0;
        for (int i = 0; i < PAPER_COUNT; i++) {
            PAPERS[i][0] = sc.nextInt();
            PAPERS[i][1] = sc.nextInt();
            if (MAX_ROW < PAPERS[i][0]) {
                MAX_ROW = PAPERS[i][0];
            }
            if (MAX_COLUMN < PAPERS[i][1]) {
                MAX_COLUMN = PAPERS[i][1];
            }
        }
    }

    private static boolean[][] updateMap() {
        boolean[][] map = new boolean[MAX_ROW + LENGTH + 1][MAX_COLUMN + LENGTH + 1];
        for (int i = 0; i < PAPER_COUNT; i++) {
            int x = PAPERS[i][0];
            int y = PAPERS[i][1];
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    map[j][k] = true;
                }
            }
        }
        return map;
    }

    private static void answer(boolean[][] map) {
        int answer = 0;
        for (boolean[] booleans : map) {
            for (boolean aBoolean : booleans) {
                if (aBoolean) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}

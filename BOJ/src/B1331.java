/**
 * playtime = 50:56
 */

import java.util.ArrayList;
import java.util.Scanner;

public class B1331 {
    private static ArrayList<String> input = new ArrayList<>();
    private static int[][] map = new int[6][6];
    private static int bx = -1;
    private static int by = -1;
    private static final int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    private static final int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) {
        input();
        if (solution()) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        String temp = "";
        for (int i = 0; i < 36; i++) {
            String str = sc.next();
            if (i == 0) {
                temp = str;
            }
            input.add(str);
        }
        input.add(temp);
    }

    private static boolean solution() {
        for (String s : input) {
            char x = s.charAt(1);
            char y = s.charAt(0);
            if (bx == -1 && by == -1) {
                bx = x - '0' - 1;
                by = y - 'A';
            } else {
                if (isCollect(x - '0' - 1, y - 'A') && map[x - '0' - 1][y - 'A'] != 1) {
                    map[(int) x - '0' - 1][y - 'A'] = 1;
                    bx = x - '0' - 1;
                    by = y - 'A';
                } else {
                    return false;
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isCollect(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = bx + dx[i];
            int ny = by + dy[i];
            if (nx == x && ny == y) {
                if (nx >= 0 && nx < 6 && ny >= 0 && ny < 6 && map[nx][ny] != 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

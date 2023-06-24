/**
 * playtime = 01:20:27
 */

import java.util.Scanner;

public class B1063 {

    private static final int INIT = 0;
    private static final int KING = 1;
    private static final int STONE = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[8][8];
        String king = sc.next();
        int kx = findX(king);
        int ky = king.charAt(1) - '1';
        board[kx][ky] = KING;

        String stone = sc.next();
        int sx = findX(stone);
        int sy = stone.charAt(1) - '1';
        board[sx][sy] = STONE;

        int n = sc.nextInt();

        while (n-- > 0) {
            String input = sc.next();
            if ("R".equals(input)) {
                if (checkRange(kx + 1, ky)) {
                    continue;
                }
                if (board[kx + 1][ky] == STONE) {
                    if (checkRange(sx + 1, sy)) {
                        continue;
                    }
                }
                board[kx][ky] = INIT;
                kx += 1;
                if (board[kx][ky] == STONE) {
                    board[sx][sy] = INIT;
                    sx += 1;
                    board[sx][sy] = STONE;
                }
                board[kx][ky] = KING;
            } else if ("L".equals(input)) {
                if (checkRange(kx - 1, ky)) {
                    continue;
                }
                if (board[kx - 1][ky] == STONE) {
                    if (checkRange(sx - 1, sy)) {
                        continue;
                    }
                }
                board[kx][ky] = INIT;
                kx -= 1;
                if (board[kx][ky] == STONE) {
                    board[sx][sy] = INIT;
                    sx -= 1;
                    board[sx][sy] = STONE;
                }
                board[kx][ky] = KING;
            } else if ("B".equals(input)) {
                if (checkRange(kx, ky - 1)) {
                    continue;
                }
                if (board[kx][ky - 1] == STONE) {
                    if (checkRange(sx, sy - 1)) {
                        continue;
                    }
                }
                board[kx][ky] = INIT;
                ky -= 1;
                if (board[kx][ky] == STONE) {
                    board[sx][sy] = INIT;
                    sy -= 1;
                    board[sx][sy] = STONE;
                }
                board[kx][ky] = KING;
            } else if ("T".equals(input)) {
                if (checkRange(kx, ky + 1)) {
                    continue;
                }
                if (board[kx][ky + 1] == STONE) {
                    if (checkRange(sx, sy + 1)) {
                        continue;
                    }
                }
                board[kx][ky] = INIT;
                ky += 1;
                if (board[kx][ky] == STONE) {
                    board[sx][sy] = INIT;
                    sy += 1;
                    board[sx][sy] = STONE;
                }
                board[kx][ky] = KING;
            } else if ("RT".equals(input)) {
                if (checkRange(kx + 1, ky + 1)) {
                    continue;
                }
                if (board[kx + 1][ky + 1] == STONE) {
                    if (checkRange(sx + 1, sy + 1)) {
                        continue;
                    }
                }
                board[kx][ky] = INIT;
                kx += 1;
                ky += 1;
                if (board[kx][ky] == STONE) {
                    board[sx][sy] = INIT;
                    sx += 1;
                    sy += 1;
                    board[sx][sy] = STONE;
                }
                board[kx][ky] = KING;
            } else if ("LT".equals(input)) {
                if (checkRange(kx - 1, ky + 1)) {
                    continue;
                }
                if (board[kx - 1][ky + 1] == STONE) {
                    if (checkRange(sx - 1, sy + 1)) {
                        continue;
                    }
                }
                board[kx][ky] = INIT;
                kx -= 1;
                ky += 1;
                if (board[kx][ky] == STONE) {
                    board[sx][sy] = INIT;
                    sx -= 1;
                    sy += 1;
                    board[sx][sy] = STONE;
                }
                board[kx][ky] = KING;
            } else if ("RB".equals(input)) {
                if (checkRange(kx + 1, ky - 1)) {
                    continue;
                }
                if (board[kx + 1][ky - 1] == STONE) {
                    if (checkRange(sx + 1, sy - 1)) {
                        continue;
                    }
                }
                board[kx][ky] = INIT;
                kx += 1;
                ky -= 1;
                if (board[kx][ky] == STONE) {
                    board[sx][sy] = INIT;
                    sx += 1;
                    sy -= 1;
                    board[sx][sy] = STONE;
                }
                board[kx][ky] = KING;
            } else if ("LB".equals(input)) {
                if (checkRange(kx - 1, ky - 1)) {
                    continue;
                }
                if (board[kx - 1][ky - 1] == STONE) {
                    if (checkRange(sx - 1, sy - 1)) {
                        continue;
                    }
                }
                board[kx][ky] = INIT;
                kx -= 1;
                ky -= 1;
                if (board[kx][ky] == STONE) {
                    board[sx][sy] = INIT;
                    sx -= 1;
                    sy -= 1;
                    board[sx][sy] = STONE;
                }
                board[kx][ky] = KING;
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 1) {
                    System.out.print((char) (i + 'A'));
                    System.out.print(j + 1);
                    System.out.println();
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 2) {
                    System.out.print((char) (i + 'A'));
                    System.out.print(j + 1);
                    System.out.println();
                }
            }
        }
    }

    private static int findX(String king) {
        return king.charAt(0) - 'A';
    }

    private static boolean checkRange(int x, int y) {
        return x < 0 || y < 0 || x >= 8 || y >= 8;
    }
}

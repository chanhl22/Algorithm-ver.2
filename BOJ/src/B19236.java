import java.util.Arrays;
import java.util.Scanner;

public class B19236 {
    static int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dy[] = {0, -1, -1, -1, 0, 1, 1, 1};

    static int[][] copy_array(int[][] original){
        int[][] result = new int[4][4];
        for (int i = 0; i < 4; i++) {
            result[i] = Arrays.copyOf(original[i], 4);
        }
        return result;
    }

    static int go(int[][] board, int[][] dir, int x, int y, int d) {
        int ans = 0;
        // 물고기 이동
        for (int who = 1; who <= 16; who++) {
            for (int i = 0; i < 4; i++) {
                boolean ok = false;
                for (int j = 0; j < 4; j++) {
                    if (board[i][j] == who) {
                        for (int k = 0; k < 8; k++) {
                            int nx = i + dx[dir[i][j]];
                            int ny = j + dy[dir[i][j]];
                            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && !(nx == x && ny == y)) {
                                int temp = board[nx][ny];
                                board[nx][ny] = board[i][j];
                                board[i][j] = temp;
                                temp = dir[nx][ny];
                                dir[nx][ny] = dir[i][j];
                                dir[i][j] = temp;
                                ok = true;
                                break;
                            } else {
                                dir[i][j] += 1;
                                dir[i][j] %= 8;
                            }
                        }
                    }
                    if (ok) break;
                }
                if (ok) break;
            }
        }
        // 상어 이동
        int sx = x + dx[d];
        int sy = y + dy[d];
        while (sx >= 0 && sx < 4 && sy >= 0 && sy < 4) {
            if (board[sx][sy] != 0){
                int temp = board[sx][sy];
                board[sx][sy] = 0;
                int cur = go(copy_array(board), copy_array(dir), sx, sy, dir[sx][sy]) + temp;
                if(ans < cur) {
                    ans = cur;
                }
                board[sx][sy] = temp;
            }
            sx += dx[d];
            sy += dy[d];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[4][4];
        int[][] dir = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = sc.nextInt();
                dir[i][j] = sc.nextInt();
                dir[i][j] -= 1;
            }
        }

        int ans = board[0][0];
        board[0][0] = 0;
        ans += go(board, dir, 0, 0, dir[0][0]);
        System.out.println(ans);
    }
}

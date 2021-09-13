import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16948 {
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// board input
        int r1 = sc.nextInt();// start x
        int c1 = sc.nextInt();// start y
        int r2 = sc.nextInt();// finish x
        int c2 = sc.nextInt();// finish y
        int[][] board = new int[n][n]; //board
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], -1);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(r1);
        q.add(c1);
        board[r1][c1] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if(board[nx][ny] == -1){
                        q.add(nx);
                        q.add(ny);
                        board[nx][ny] = board[x][y] + 1;
                    }
                }
            }
        }
        if(board[r2][c2] == -1){
            System.out.println(-1);
        }else {
            System.out.println(board[r2][c2]);
        }
    }
}

//playtime = 01:14:52
//문제를 잘못 읽어서 필요없는 조건들이 추가되었다.
//큰 틀은 바뀌지 않지만 좀 더 간단한 코드로 리펙토링이 가능하다.
//참고: https://near-apparatus-275.notion.site/11559-Puyo-Puyo-76b8239d85b642da8e543c2b7fb98c03

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Puyo{
    int x;
    int y;
    char color;

    public Puyo(int x, int y, char color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
}

public class B11559 {
    static char[][] field;
    static final int row = 12;
    static final int col = 6;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        field = new char[row][col];
        for (int i = 0; i < row; i++) {
            field[i] = sc.next().toCharArray();
        }
        while (true) {
            boolean finish = true;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (field[i][j] != '.') {
                        if (bfs(i, j)) {
                            finish = false;
                        }
                    }
                }
            }
            if (finish) break;
            moveField(); //field 를 이동시킴
            ans++;
        }
        System.out.println(ans);
    }

    private static boolean bfs(int sx, int sy) {
        Queue<Puyo> q = new LinkedList<>();
        q.add(new Puyo(sx, sy, field[sx][sy]));
        boolean[][] check = new boolean[row][col];
        check[sx][sy] = true;
        int count = 1;
        while (!q.isEmpty()) {
            Puyo p = q.remove();
            int x = p.x;
            int y = p.y;
            int color = p.color;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                    if (check[nx][ny] == false && field[nx][ny] == color) {
                        q.add(new Puyo(nx, ny, field[nx][ny]));
                        check[nx][ny] = true;
                        count++;
                    }
                }
            }
        }

        boolean ok = false;
        //사라지는 뿌요 없애기
        if (count >= 4) {
            ok = true;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (check[i][j] == true) {
                        field[i][j] = '.';
                    }
                }
            }
        }
        return ok;
    }

    private static void moveField() {
        for (int j = 0; j < col; j++) {
            for (int i = row - 1; i >= 0; i--) {
                if (field[i][j] == '.') {
                    for (int k = i - 1; k >= 0; k--) {
                        if (field[k][j] != '.') {
                            field[i][j] = field[k][j];
                            field[k][j] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}
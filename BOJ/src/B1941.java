//playtime = 01:22:58

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1941 {
    static int[] num; //일차원 배열
    static boolean[][] check;
    static int ans = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new char[5][5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.next().toCharArray();
        }
        num = new int[25];
        for (int i = 0; i < 25; i++) {
            num[i] = i;
        }
        check = new boolean[5][5];
        go(0, 0, 0);
        System.out.println(ans);
    }

    private static void go(int index, int cnt, int s) {
        if (cnt == 7 || index == 25) {
            if (s >= 4) {
                if (bfs()) {
                    ans++;
                }
            }
            return;
        }
        check[index / 5][index % 5] = true;
        if (arr[index / 5][index % 5] == 'S') {
            go(index + 1, cnt + 1, s + 1);
        } else {
            go(index + 1, cnt + 1, s);
        }
        check[index / 5][index % 5] = false;
        go(index + 1, cnt, s);
    }

    private static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        int sx = -1;
        int sy = -1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (check[i][j] == true && arr[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
            }
        }
        if (sx == -1 && sy == -1) {
            return false;
        }
        q.add(sx);
        q.add(sy);
        int[][] visited = new int[5][5];
        visited[sx][sy] = 1;
        int count = 1;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                    if (check[nx][ny] == true && visited[nx][ny] == 0) {
                        q.add(nx);
                        q.add(ny);
                        visited[nx][ny] = visited[x][y] + 1;
                        count++;
                    }
                }
            }
        }
        if (count == 7) {
            return true;
        }
        return false;
    }
}

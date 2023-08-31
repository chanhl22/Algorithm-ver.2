/**
 * 01:56:50
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Store2564 {
    int dir;
    int dist;
    boolean isMe;
    int x;
    int y;

    public Store2564(int dir, int dist, boolean isMe) {
        this.dir = dir;
        this.dist = dist;
        this.isMe = isMe;
    }
}

public class B2564 {
    private static int xLen;
    private static int yLen;
    private static int n;
    private static final ArrayList<Store2564> stores = new ArrayList<>();
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        yLen = sc.nextInt() + 1;
        xLen = sc.nextInt() + 1;
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            stores.add(new Store2564(sc.nextInt(), sc.nextInt(), false));
        }
        stores.add(new Store2564(sc.nextInt(), sc.nextInt(), true));
    }

    private static void solution() {
        for (Store2564 store : stores) {
            if (store.dir == 1) {
                store.x = 0;
                store.y = store.dist;
            } else if (store.dir == 2) {
                store.x = xLen - 1;
                store.y = store.dist;
            } else if (store.dir == 3) {
                store.x = store.dist;
                store.y = 0;
            } else {
                store.x = store.dist;
                store.y = yLen - 1;
            }
        }

        int sx = 0;
        int sy = 0;
        for (Store2564 store : stores) {
            if (store.isMe) {
                sx = store.x;
                sy = store.y;
            }
        }

        int[][] map = bfs(sx, sy);

        int result = 0;
        for (Store2564 store : stores) {
            if (!store.isMe) {
                result += map[store.x][store.y];
            }
        }
        System.out.println(result);
    }

    private static int[][] bfs(int sx, int sy) {
        int[][] map = new int[xLen][yLen];
        for (int i = 1; i < xLen - 1; i++) {
            for (int j = 1; j < yLen - 1; j++) {
                map[i][j] = -1;
            }
        }
        boolean[][] isVisited = new boolean[xLen][yLen];
        Queue<Integer> q = new LinkedList<>();
        q.add(sx);
        q.add(sy);
        map[sx][sy] = 0;
        isVisited[sx][sy] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < xLen && ny >= 0 && ny < yLen) {
                    if (!isVisited[nx][ny] && map[nx][ny] != -1) {
                        q.add(nx);
                        q.add(ny);
                        map[nx][ny] = map[x][y] + 1;
                        isVisited[nx][ny] = true;
                    }
                }
            }
        }
        return map;
    }
}

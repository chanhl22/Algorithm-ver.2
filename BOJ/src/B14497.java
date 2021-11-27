//playtime = 34:00

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B14497 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x1 = sc.nextInt() - 1;
        int y1 = sc.nextInt() - 1;
        int x2 = sc.nextInt() - 1;
        int y2 = sc.nextInt() - 1;
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == '#') {
                    map[i][j] = 1;
                } else if (s.charAt(j) == '*') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = s.charAt(j) - '0';
                }
            }
        }
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int count = 0;
        while (true) {
            Queue<Integer> q = new LinkedList<>();
            q.add(x1);
            q.add(y1);
            boolean[][] check = new boolean[n][m];
            check[x1][y1] = true;
            while (!q.isEmpty()) {
                int x = q.remove();
                int y = q.remove();
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
//                        if (check[nx][ny] == false && map[nx][ny] != 2) {
//                            if (map[nx][ny] == 1) {
//                                map[nx][ny] = 2;
//                                continue;
//                            }
//                            q.add(nx);
//                            q.add(ny);
//                            check[nx][ny] = true;
//                        }
                        if (check[nx][ny] == false && map[nx][ny] == 0) {
                            q.add(nx);
                            q.add(ny);
                            check[nx][ny] = true;
                        } else {
                            map[nx][ny] = 2;
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j] == 2) {
                        map[i][j] = 0;
                    }
                }
            }
            count++;
            if (map[x2][y2] != 1) {
                System.out.println(count);
                break;
            }
        }
    }
}

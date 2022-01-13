//playtime = 14:23

import java.util.Scanner;

public class B3023 {
    static char[][] map;
    static char[][] new_map;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = sc.next().toCharArray();
        }
        int err_x = sc.nextInt() - 1;
        int err_y = sc.nextInt() - 1;
        new_map = new char[2 * n][2 * m];
        make_map();
        if (new_map[err_x][err_y] == '.') {
            new_map[err_x][err_y] = '#';
        } else if (new_map[err_x][err_y] == '#') {
            new_map[err_x][err_y] = '.';
        }
        for (int i = 0; i < 2 * n; i++) {
            for (int j = 0; j < 2 * m; j++) {
                System.out.print(new_map[i][j]);
            }
            System.out.println();
        }
    }

    private static void make_map() {
        //...1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                new_map[i][j] = map[i][j];
            }
        }
        //...2
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                new_map[i][2 * m - 1 - j] = map[i][j];
            }
        }
        //...3
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                new_map[2 * n -1 - i][j] = map[i][j];
            }
        }
        //...4
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                new_map[2 * n -1 - i][2 * m - 1 - j] = map[i][j];
            }
        }
    }
}

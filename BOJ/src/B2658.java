/*
반례 해결 못함
0001000000
0011010000
0111110000
1111111000
0000000000
0000000000
0000000000
0000000000
0000000000
0000000000
 */

import java.util.Arrays;
import java.util.Scanner;

class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point that) {
        if (this.x < that.x) {
            return -1;
        } else if (this.x == that.x) {
            if (this.y < that.y) {
                return -1;
            } else if (this.y == that.y) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}

public class B2658 {
    static void find(int[][] map, int r, int c) {
        Point[] p = new Point[3];
        if (r < c) { //직선은 세로
            boolean ok = false;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (map[i][j] == 1) {
                        p[0] = new Point(i, j);
                        ok = true;
                        break;
                    }
                }
                if (ok) break;
            }
            p[1] = new Point(p[0].x + c, p[0].y);
            int max = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (map[i][j] == 1) {
                        if (max < j) {
                            max = j;
                        }
                    }
                }
            }
            if (max == p[0].y) {
                p[2] = new Point(p[0].x + c / 2, p[0].y - r);
            } else {
                p[2] = new Point(p[0].x + c / 2, p[0].y + r);
            }
        } else { //직선은 가로
            boolean ok = false;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (map[j][i] == 1) {
                        p[0] = new Point(j, i);
                        ok = true;
                        break;
                    }
                }
                if (ok) break;
            }
            p[1] = new Point(p[0].x, p[0].y + r);
            int max = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (map[i][j] == 1) {
                        if (max < i) {
                            max = i;
                        }
                    }
                }
            }
            if (max == p[0].x) {
                p[2] = new Point(p[0].x - c, p[0].y + r / 2);
            } else {
                p[2] = new Point(p[0].x + c, p[0].y + r / 2);
            }
        }
        Arrays.sort(p);
        for (int i = 0; i < 3; i++) {
            int nx = p[i].x + 1;
            int ny = p[i].y + 1;
            System.out.println(nx + " " + ny);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] map = new int[10][10];
        for (int i = 0; i < 10; i++) {
            String s = sc.next();
            for (int j = 0; j < 10; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        int r = 0;
        int c = 0;
        boolean check = false;
        for (int i = 0; i < 10; i++) {
            int temp1 = 0;
            int temp2 = 0;
            boolean ok1 = false;
            boolean ok2 = false;
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 1) {
                    temp1++;
                    ok1 = true;
                }
                if (r < temp1) {
                    r = temp1;
                }
                if (ok1 == true && map[i][j] == 0) {
                    ok1 = false;
                    temp1 = 0;
                }
            }
            for (int j = 0; j < 10; j++) {
                if (map[j][i] == 1) {
                    temp2++;
                    ok2 = true;
                }
                if (c < temp2) {
                    c = temp2;
                }
                if (ok2 == true && map[j][i] == 0) {
                    ok2 = false;
                    temp2 = 0;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 1) {
                    cnt++;
                }
            }
        }
        int temp_cnt = 0;
        for (int i = Math.max(r, c); i > 0; i -= 2) {
            temp_cnt += i;
        }
        r -= 1;
        c -= 1;
        if (cnt != temp_cnt) {
            System.out.println(0);
        } else if (r == 0 || c == 0) {
            System.out.println(0);
        } else if (r * 2 == c || c * 2 == r) {
            find(map, r, c);
        } else {
            System.out.println(0);
        }
    }
}

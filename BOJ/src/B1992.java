//playtime = 34:25

import java.util.Scanner;

public class B1992 {
    static StringBuilder sb = new StringBuilder();
    static int[][] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        divide(0, 0, n);
        System.out.println(sb.toString());
    }

    private static void divide(int x, int y, int n) {
        if (check(x, y, n)) {
            sb.append(a[x][y]);
            return;
        }
        int size = n / 2;
        sb.append('(');
        divide(x, y, size);
        divide(x, y + size, size);
        divide(x + size, y, size);
        divide(x + size, y + size, size);
        sb.append(')');
    }

    private static boolean check(int x, int y, int n) {
        int tmp = a[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (tmp != a[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

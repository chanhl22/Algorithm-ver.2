import java.util.Scanner;

public class B1018 {
    static int n;
    static int m;
    static char[][] a;

    static int paint_1(int x, int y) {
        int cnt = 0;
        for (int i = x; i < x+8; i++) {
            for (int j = y; j < y+8; j++) {
                if (i%2 == 0) {
                    if (j%2 == 0) {
                        if (a[i][j] !='W') {
                            cnt++;
                        }
                    } else if ((j+1) %2 == 0) {
                        if (a[i][j] !='B') {
                            cnt++;
                        }
                    }
                } else if ((i+1) %2 == 0) {
                    if (j%2 == 0) {
                        if (a[i][j] !='B') {
                            cnt++;
                        }
                    } else if ((j+1) %2 == 0) {
                        if (a[i][j] !='W') {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    static int paint_2(int x, int y) {
        int cnt = 0;
        for (int i = x; i < x+8; i++) {
            for (int j = y; j < y+8; j++) {
                if (i%2 == 0) {
                    if (j%2 == 0) {
                        if (a[i][j] !='B') {
                            cnt++;
                        }
                    } else if ((j+1) %2 == 0) {
                        if (a[i][j] !='W') {
                            cnt++;
                        }
                    }
                } else if ((i+1) %2 == 0) {
                    if (j%2 == 0) {
                        if (a[i][j] !='W') {
                            cnt++;
                        }
                    } else if ((j+1) %2 == 0) {
                        if (a[i][j] !='B') {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    static int check(int x, int y) {
        int temp1 = paint_1(x, y);
        int temp2 = paint_2(x, y);
        return Math.min(temp1, temp2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.next().toCharArray();
        }
        int ans = -1;
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int temp = check(i, j);
                if (ans == -1 || ans > temp) {
                    ans = temp;
                }
            }
        }
        System.out.println(ans);
    }
}

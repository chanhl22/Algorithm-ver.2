import java.util.Scanner;

public class B11048_4 {
    static int[][] a;
    static int[][] d;

    static int go(int x, int y){
        if (x < 1 || y < 1){
            return 0;
        }
        if (d[x][y] >= 0) {
            return d[x][y];
        }
        d[x][y] = Math.max(go(x-1,y), go(x,y-1)) + a[x][y];
        return d[x][y];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        a = new int[n+1][m+1];
        d = new int[n+1][m+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                a[i][j] = sc.nextInt();
                d[i][j] = -1;
            }
        }
        System.out.println(go(n,m));
    }
}

import java.util.Scanner;

public class B14503 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = sc.nextInt();
			}
		}
        while (true) {
        	if (a[r][c] == 0) {
        		a[r][c] = 2;        		
        	}
        	if (a[r+1][c] != 0 && a[r-1][c] != 0 && a[r][c+1] != 0 && a[r][c-1] != 0) {
        		if (a[r-dx[d]][c-dy[d]] == 1) {
        			break;
        		} else {
        			r -= dx[d];
        			c -= dy[d];
        		}
        	} else {
        		d = (d + 3) % 4;
        		if (a[r+dx[d]][c+dy[d]] == 0) {
        			r += dx[d];
        			c += dy[d];
        		}
        	}
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
				if (a[i][j] == 2) {
					ans += 1;
				}
			}
		}
        System.out.println(ans);
    }
}

import java.util.Scanner;

public class B1932 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] a = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		int[][] d = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				d[i][j] = Math.max(d[i-1][j], d[i-1][j-1]) + a[i][j];
			}
		}
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if(ans < d[n][i])
				ans = d[n][i];
		}
		System.out.println(ans);
		
	}

}

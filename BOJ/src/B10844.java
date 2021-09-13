import java.util.Scanner;

public class B10844 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] d = new long[101][10];
		
		for (int i = 1; i <= 9; i++) {
			d[1][i] = 1;
		}
//		d[1][0] = 0;
		
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 9 ; j++) {
				if (j == 0) {
					d[i][j] = d[i-1][j+1];
				}
				else if (1<= j && j <= 8) {
					d[i][j] = d[i-1][j-1] + d[i-1][j+1];					
				}
				else if (j == 9) {
					d[i][j] = d[i-1][j-1];
				}
				d[i][j] %= 1000000000;  
			}
		}
		long ans = 0;
		for (int i = 0; i <= 9; i++) {
			ans += d[n][i];
		}
		ans %= 1000000000;
		System.out.println(ans);
	}

}

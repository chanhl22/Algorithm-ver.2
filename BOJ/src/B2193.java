import java.util.Scanner;

public class B2193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] d = new long[n+1][2];
		
		d[1][1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 1; j++) {
				if (j == 0) {
					d[i][j] = d[i-1][0] + d[i-1][1];				
				}
				else if (j == 1) {
					d[i][j] = d[i-1][0];				
				}
			}
		}
		long ans = d[n][0] + d[n][1];
		System.out.println(ans);
	}

}

import java.util.Scanner;

public class B2225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		long[][] d = new long[k+1][n+1];
		d[0][0] = 1;
		for (int i = 1; i <= k; i++) { //k개의 개수
			for (int j = 0; j <= n; j++) { //합의 경우의 수
				for (int l = 0; l <= j; l++) { //마지막 수
					d[i][j] += d[i-1][j-l];
					d[i][j] %= 1000000000;
				}
			}
		}
		System.out.println(d[k][n]);
	}

}

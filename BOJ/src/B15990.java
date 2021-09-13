import java.util.Scanner;

public class B15990 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] d = new long[100001][4];
		for (int i = 1; i <= 100000; i++) {
			if (i>1) {
				d[i][1] = d[i-1][2] + d[i-1][3];  
			}
			if (i == 1) {
				d[i][1] = 1;
			}				
			if (i>2) {
				d[i][2] = d[i-2][1] + d[i-2][3];
			}
			if (i == 2) {
				d[i][2] = 1;
			}
			if (i>3) {
				d[i][3] = d[i-3][1] + d[i-3][2];			
			}
			if (i == 3) {
				d[i][3] = 1;
			}
			d[i][1] %= 1000000009;
            d[i][2] %= 1000000009;
            d[i][3] %= 1000000009;
		}
		while (n-- > 0) {
			int a = sc.nextInt();
			System.out.println((d[a][1] + d[a][2] + d[a][3])%1000000009);
		}
	}
}
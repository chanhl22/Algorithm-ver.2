import java.util.Scanner;

public class B2133 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[n+1];
		d[0] = 1;
		for (int i = 1; i <= n; i++) {
			if (i%2 != 0)
				d[i] = 0;
			else {
				d[i] = 3 * d[i-2];
				for (int j = 0; j <= i-4; j += 2) {
					d[i] += 2*d[j];
				}
			}
		}
		System.out.println(d[n]);

	}

}
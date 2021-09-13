import java.util.Scanner;

public class B11055 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}
		
		int[] d = new int[n+1];
		for (int i = 1; i <= n; i++) {
			d[i] = a[i];
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if (d[i] < d[j] + a[i] && a[i] > a[j])
					d[i] = d[j] + a[i];
			}
		}
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (ans < d[i])
				ans = d[i];
		}
		System.out.println(ans);
	}

}

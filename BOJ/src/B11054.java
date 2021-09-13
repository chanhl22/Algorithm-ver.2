import java.util.Scanner;

public class B11054 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}
		
		int[] d = new int[n+1];
		for (int i = 1; i <= n; i++) {
			d[i] = 1;
			for (int j = 1; j <= i; j++) {
				if (d[i] < d[j] + 1 && a[j] < a[i])
					d[i] = d[j] + 1;
			}
		}
		int[] d2 = new int[n+1];
		for (int i = n; i > 0; i--) {
			d2[i] = 1;
			for (int j = i; j <= n; j++) {
				if (d2[i] < d2[j] + 1 && a[i] > a[j])
					d2[i] = d2[j] + 1;
			}
		}
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (ans < d[i] + d2[i] - 1)
				ans = d[i] + d2[i] - 1;	
		}
		System.out.println(ans);

	}

}

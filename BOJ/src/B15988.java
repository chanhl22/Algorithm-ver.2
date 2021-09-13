import java.util.Scanner;

public class B15988 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] d = new long [1000001];
		d[0] = 1;
		d[1] = 1;
		d[2] = 2;
		for (int j = 3; j <= 1000000 ; j++) {
				d[j] = d[j-1] + d[j-2] + d[j-3];
				d[j] %= 1000000009;
		}
		
		for (int i = 1; i <= n; i++) {
			int a = sc.nextInt();
			System.out.println(d[a] % 1000000009);
		}
	}
}

// Another Solution
//import java.util.*;
//public class Main {
//	static final long mod = 1000000009L;
//	public static void main(String args[]) {
//		Scanner sc = new Scanner(System.in);
//		long[] d = new long[1000001];
//		d[0] = 1;
//		for (int i=1; i<=1000000; i++) {
//			for (int j=1; j<=3; j++) {
//				if (i-j >= 0) {
//					d[i] += d[i-j];
//				}
//			}
//			d[i] %= mod;
//		}
//		int t = sc.nextInt();
//		while (t-- > 0) {
//			int n = sc.nextInt();
//			System.out.println(d[n]);
//		}
//	}
//}

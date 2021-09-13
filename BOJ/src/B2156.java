//import java.util.*;
//
//public class B2156 {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] a = new int[n+1];
//		for (int i = 1; i <= n; i++) {
//			a[i] = sc.nextInt();
//		}
//		
//		int[][] d = new int[n+1][3];
//		for (int i = 1; i <= n; i++) {
//			d[i][0] = Math.max(Math.max(d[i-1][0], d[i-1][1]), d[i-1][2]);
//			d[i][1] = d[i-1][0] + a[i];
//			d[i][2] = d[i-1][1] + a[i];
//		}
//		
//		System.out.println(Math.max(Math.max(d[n][0], d[n][1]), d[n][2]));
//	}
//
//}

import java.util.Scanner;

public class B2156 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}
		
		int[] d = new int[n+1];
		d[1] = a[1];
		if(n>=2)
			d[2] = a[1] + a[2];
		for (int i = 3; i <= n; i++) {
			d[i] = Math.max(Math.max(d[i-1], d[i-2] + a[i]), d[i-3] + a[i] + a[i-1]);
		}
		
		System.out.println(d[n]);
	}

}
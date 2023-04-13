/**
 * playtime = 15:11
 * 풀이횟수 = 2
 */

import java.util.Scanner;

public class B15650 {

	public static int[] arr = new int[9];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		go(0, 1, n, m);
	}

	private static void go(int count, int start, int n, int m) {
		if (count == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= n; i++) {
			arr[count] = i;
			go(count + 1, i + 1, n, m);
		}
	}
}

//import java.util.Scanner;
//
//public class B15650 {
//	static boolean[] c = new boolean[9];
//	static int[] a = new int[9];
//
//	static void go(int index, int start, int n, int m) {
//		if (index == m) {
//			for (int i = 0; i < m; i++) {
//				System.out.print(a[i]+" ");
//			}
//			System.out.println();
//			return ;
//		}
//		for (int i = start; i <= n; i++) {
//			if (c[i])
//				continue;
//			c[index] = true;
//			a[index] = i;
//			go(index+1, i+1, n, m);
//			c[index] = false;
//		}
//	}
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//
//		go(0, 1, n, m);
//	}
//
//}

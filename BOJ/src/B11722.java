//import java.util.Scanner;
//
//public class B11722 {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] a = new int[n+1];
//		for (int i = n; i >= 1; i--) {
//			a[i] = sc.nextInt();
//		}
//		
//		int[] d = new int[n+1];
//		for (int i = 1; i <= n; i++) {
//			d[i] = 1;
//		}
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= i; j++) {
//				if (d[i] < d[j] + 1 && a[i] > a[j])
//					d[i] = d[j] + 1;
//			}
//		}
//		int ans = 0;
//		for (int i = 1; i <= n; i++) {
//			if (ans < d[i])
//				ans = d[i];
//		}
//		System.out.println(ans);
//	}
//
//}

//import java.util.Scanner;
//
//public class B11722 {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] a = new int[n+1];
//		for (int i = 1; i <= n; i++) {
//			a[i] = sc.nextInt();
//		}
//		
//		int[] d = new int[n+1];
//		for (int i = 1; i <= n; i++) {
//			d[i] = 1;
//		}
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= i; j++) {
//				if (d[i] < d[j] + 1 && a[i] < a[j])
//					d[i] = d[j] + 1;
//			}
//		}
//		int ans = 0;
//		for (int i = 1; i <= n; i++) {
//			if (ans < d[i])
//				ans = d[i];
//		}
//		System.out.println(ans);
//	}
//
//}

import java.util.Scanner;

public class B11722 {

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
		}
		for (int i = n; i >= 1; i--) {
			for (int j = i; j <= n; j++) { // j = i + 1�� �� �� ��Ȯ�� ǥ��
			//j = i���� a[i] > a[j]���� �ɷ��� ������ ����
				if (d[i] < d[j] + 1 && a[i] > a[j])
					d[i] = d[j] + 1;
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
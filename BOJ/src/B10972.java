import java.util.Scanner;

public class B10972 {
    static boolean next(int[] a, int n) {
        int i = n - 1;
        while (i > 0 && a[i] <= a[i - 1]) {
            i -= 1;
        }
        if (i <= 0) {
            return false;
        }

        int j = n - 1;
        while (a[j] <= a[i - 1]) {
            j -= 1;
        }

        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        j = n - 1;
        while (i < j) {
            temp = a[j];
            a[j] = a[i];
            a[i] = temp;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        //input
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        if (next(a, n)) {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
        } else {
            System.out.println(-1);
        }
    }
}


//import java.util.*;
//
//public class B10972 {
//
//	static int n;
//
//	static boolean next(int[] arr) {
//		int i = arr.length-1;
//
//		while(i > 0 && arr[i-1] >= arr[i]) {
//			i -= 1;
//		}
//		if (i <= 0) return false;
//
//		int j = arr.length-1;
//
//		while(arr[j] <= arr[i-1]) {
//			j -= 1;
//		}
//
//		int temp;
//		temp = arr[i-1];
//		arr[i-1] = arr[j];
//		arr[j] = temp;
//
//		j = arr.length-1;
//		while (i < j) {
//			temp = arr[i];
//			arr[i] = arr[j];
//			arr[j] = temp;
//			i++;
//			j--;
//		}
//		return true;
//	}
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
//		int[] arr = new int[n];
//		for (int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
//
//		if (next(arr)) {
//			for (int i = 0; i < n; i++) {
//				System.out.print(arr[i] + " ");
//			}
//			System.out.println();
//		}
//		else {
//			System.out.println("-1");
//		}
//	}
//}


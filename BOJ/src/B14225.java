import java.util.Arrays;
import java.util.Scanner;

public class B14225 {

	static int[] arr = new int[2000000];
	static int n;
	static int k = 0;
	static int[] a;
	
	static void go(int index, int sum) {
		if(index == n) {
			arr[k] = sum;
			k++;
			return ;
		}
		go (index+1, sum + a[index]);
		go (index+1, sum);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		go(0,0);
		Arrays.sort(arr);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i-1] <= arr[i]) {
				if (!(arr[i-1] + 1 == arr[i] || arr[i-1] == arr[i])) {
					System.out.println(arr[i-1] + 1);
					break;
				}
				if (i == arr.length - 1) {
					System.out.println(arr[i] + 1);
				}
			}
		}
	}

}

//import java.util.*;
//public class Main {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        boolean[] c = new boolean[20*100000+10];
//        int[] a = new int[20];
//        int n = sc.nextInt();
//        for (int i=0; i<n; i++) {
//            a[i] = sc.nextInt();
//        }
//        for (int i=0; i<(1<<n); i++) {
//            int sum = 0;
//            for (int j=0; j<n; j++) {
//                if ((i&(1<<j)) != 0) {
//                    sum += a[j];
//                }
//            }
//            c[sum] = true;
//        }
//        for (int i=1;; i++) {
//            if (c[i] == false) {
//                System.out.println(i);
//                break;
//            }
//        }
//    }
//}


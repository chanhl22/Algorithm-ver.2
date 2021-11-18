//playtime = 15:00

//import java.util.Arrays;
//import java.util.Scanner;
//
//public class B3273 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
//        Arrays.sort(a);
//        int x = sc.nextInt();
//        int cnt = 0;
//        for (int i = 0; i < n; i++) {
//            if (a[i] <= x / 2) {
//                for (int j = n - 1; j > i; j--) {
//                    if (a[i] + a[j] == x) {
//                        cnt++;
//                    } else if (a[i] + a[j] < x) {
//                        break;
//                    }
//                }
//            } else {
//                break;
//            }
//        }
//        System.out.println(cnt);
//    }
//}

//투포인터
import java.util.Arrays;
import java.util.Scanner;

public class B3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int x = sc.nextInt();
        int left = 0, right = n - 1;
        int ans = 0;
        while(left < right) {
            int sum = a[left] + a[right];
            if (sum < x) {
                left++;
            } else if (sum == x) {
                ans++;
                left++;
            } else {
                right--;
            }
            /*
            if(sum == x) {
				ans++;
			}
			if(sum <= x) {
				left++;
			}
			else {
				right--;
			}
             */
        }
        System.out.println(ans);
    }
}
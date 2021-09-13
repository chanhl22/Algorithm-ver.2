import java.util.Scanner;

public class B1806 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0;
        int sum = a[0];
        int ans = -1;
        int now = 0;
        while (right >= left && right < n) {
            if (sum < m) {
                right += 1;
                sum += a[right];
            } else if (sum == m) {
                now = right - left + 1;
                if (ans == -1 || ans > now) {
                    ans = now;
                }
                right += 1;
                sum += a[right];
            } else if (sum > m) {
                now = right - left + 1;
                if (ans == -1 || ans > now) {
                    ans = now;
                }
                sum -= a[left];
                left += 1;
                if (left > right && left < n) {
                    right = left;
                    sum = a[left];
                }
            }
        }
        if (ans == -1) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }
}

//import java.util.*;
//
//public class B1806 {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int s = sc.nextInt();
//        int[] a = new int[n+1];
//        for (int i=0; i<n; i++) {
//            a[i] = sc.nextInt();
//        }
//        int i=0;
//        int j=0;
//        int sum=a[0];
//        int ans=n+1;
//        while (i <= j && j < n) {
//            if (sum < s) {
//                j += 1;
//                sum += a[j];
//            } else if (sum == s) {
//                ans = Math.min(j-i+1,ans);
//                j += 1;
//                sum += a[j];
//            } else if (sum > s) {
//                ans = Math.min(j-i+1,ans);
//                sum -= a[i];
//                i++;
//            }
//        }
//        if (ans > n) {
//            ans = 0;
//        }
//        System.out.println(ans);
//    }
//}
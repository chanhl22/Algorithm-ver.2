//playtime = 55:15

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int[] lecture = new int[n];
        arr = br.readLine().split(" ");
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            lecture[i] = Integer.parseInt(arr[i]);
            right += lecture[i];
            if (left < lecture[i]) {
                left = lecture[i];
            }
        }
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (checkBlueRay(mid, lecture, m)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    private static boolean checkBlueRay(int mid, int[] lecture, int m) {
        int temp = 0;
        int count = 0;
        for (int i = 0; i < lecture.length; i++) {
            temp += lecture[i];
            if (temp > mid) {
                i--;
                temp = 0;
                count++;
            }
        }
        if (count < m) {
            return true;
        } else {
            return false;
        }
    }
}

//Another Solution
//import java.util.*;
//
//public class B2343 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int a[] = new int[n];
//        int left = 0;
//        int right = 0;
//        for(int i=0; i<n; i++) {
//            a[i] = sc.nextInt();
//            right += a[i];
//            left = left < a[i] ? a[i] : left;
//        }
//
//        while(left <= right) {
//            int mid = (left + right)/2;
//            int sum = 0;
//            int cnt = 0;
//            for(int i=0; i<n; i++) {
//                if(sum + a[i] > mid) {
//                    sum = 0; cnt++;
//                }
//                sum += a[i];
//            }
//            if(sum != 0) cnt++;
//            if(cnt <= m) right = mid-1;
//            else left = mid+1;
//        }
//        System.out.println(left);
//    }
//}
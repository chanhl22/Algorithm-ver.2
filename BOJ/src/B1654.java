//playtime = 1:00:00

import java.util.Scanner;

public class B1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[k];
        long max = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        long min = 1;
        long mid = 0;
        while (min <= max) {
            mid = (min + max) / 2;
            long cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                cnt += (arr[i] / mid);
            }
            if(cnt < n) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(max);
    }
}
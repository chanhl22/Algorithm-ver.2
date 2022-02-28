//playtime = 17:26

import java.util.Arrays;
import java.util.Scanner;

public class B3079 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = sc.nextInt();
        }
        Arrays.sort(time);
        long left = 0;
        long right = (long) m * time[n - 1];
        long mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            long temp = 0;
            for (int i = 0; i < n; i++) {
                temp += mid / time[i];
            }
            if (temp >= m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }
}

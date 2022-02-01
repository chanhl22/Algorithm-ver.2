//playtime = 39:52

import java.util.Arrays;
import java.util.Scanner;

public class B16401 {
    static int[] snack;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        snack = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            snack[i] = sc.nextInt();
            if (snack[i] > max) {
                max = snack[i];
            }
        }
        Arrays.sort(snack);
        int left = 0;
        int right = max;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }

    private static boolean check(int mid) {
        int cnt = 0;
        if (mid == 0) {
            return true;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (snack[i] < mid) {
                break;
            }
            cnt += snack[i] / mid;
        }
        if (cnt >= m) {
            return true;
        } else {
            return false;
        }
    }
}

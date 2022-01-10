//playtime = 46:34

import java.util.Arrays;
import java.util.Scanner;

public class B2512 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] money = new int[n];
        for (int i = 0; i < n; i++) {
            money[i] = sc.nextInt();
        }
        Arrays.sort(money);
        int m = sc.nextInt();
        int left = 0;
        int right = money[n - 1];
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            int temp = m;
            for (int i = 0; i < n; i++) {
                if (mid >= money[i]) {
                    temp -= money[i];
                } else {
                    temp -= mid;
                }
            }
            if (temp < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(right);
    }
}

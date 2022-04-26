//playtime = 12:05

import java.util.Arrays;
import java.util.Scanner;

public class B15903 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        while (m-- > 0) {
            Arrays.sort(arr);
            long temp = arr[0] + arr[1];
            arr[0] = temp;
            arr[1] = temp;
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}

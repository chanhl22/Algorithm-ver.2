//playtime = 17:35

import java.util.Arrays;
import java.util.Scanner;

public class B2485 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int[] check = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            check[i] = arr[i + 1] - arr[i];
        }
        int gcd = check[0];
        for (int i = 1; i < n - 1; i++) {
            gcd = gcd(gcd, check[i]);
        }
        int count = 0;
        for (int i = arr[0], j = 0; i <= arr[n - 1]; i+=gcd) {
            if (j < n && i != arr[j]) {
                count++;
            } else {
                j++;
            }
        }
        System.out.println(count);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}

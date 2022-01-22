//playtime = 33:54

import java.util.Scanner;

public class B2725 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int[] arr = new int[1001];
        arr[1] = 3;
        for (int i = 2; i <= 1000; i++) {
            int cnt = 0;
            for (int j = 0; j <= i; j++) {
                if (gcd(i, j) == 1) {
                    cnt++;
                }
            }
            arr[i] = cnt * 2 + arr[i - 1];
        }
        while (c-- > 0) {
            int n = sc.nextInt();
            System.out.println(arr[n]);
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}

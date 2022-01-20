//playtime = 01:30:38

import java.util.Scanner;

public class B14476 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        //누적 합을 활용한 누적 최대공약수
        int[] l_to_r = new int[n];
        int[] r_to_l = new int[n];
        l_to_r[0] = num[0];
        for (int i = 1; i < n; i++) {
            l_to_r[i] = gcd(l_to_r[i - 1], num[i]);
        }
        r_to_l[n - 1] = num[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            r_to_l[i] = gcd(r_to_l[i + 1], num[i]);
        }
        int max = 0;
        int maxIndex = -1;
        for (int i = 0; i < n; i++) {
            int g = 0;
            if (i == 0) {
                g = r_to_l[1];
            } else if (i == n - 1) {
                g = l_to_r[n - 2];
            } else {
                g = gcd(l_to_r[i - 1], r_to_l[i + 1]);
            }
            //나머지 수의 최대공약수가 K의 약수가 되면 안 된다.
            //num[i] % g != 0
            if(max < g && num[i] % g != 0) {
                max = g;
                maxIndex = num[i];
            }
        }
        System.out.println(maxIndex == -1 ? -1 : max + " " + maxIndex);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}

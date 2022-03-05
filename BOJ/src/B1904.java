//playtime = 27:55

import java.util.Scanner;

public class B1904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n + 2];
        d[1] = 1;
        d[2] = 2;
        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] % 15746 + d[i - 2] % 15746;
        }
        System.out.println(d[n] % 15746);
    }
}
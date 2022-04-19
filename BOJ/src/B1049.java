//playtime = 16:57

import java.util.Arrays;
import java.util.Scanner;

public class B1049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] six = new int[m];
        int[] one = new int[m];
        for (int i = 0; i < m; i++) {
            six[i] = sc.nextInt();
            one[i] = sc.nextInt();
        }
        Arrays.sort(six);
        Arrays.sort(one);
        int needMoney = 0;
        while (n > 0) {
            if (n >= 6) {
                if (one[0] * 6 > six[0]) {
                    n -= 6;
                    needMoney += six[0];
                } else {
                    needMoney += one[0] * n;
                    n = 0;
                }
            } else {
                if (one[0] * n > six[0]) {
                    n -= 6;
                    needMoney += six[0];
                } else {
                    needMoney += one[0] * n;
                    n = 0;
                }
            }
        }
        System.out.println(needMoney);
    }
}

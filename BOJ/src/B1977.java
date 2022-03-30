//playtime = 4:41

import java.util.Scanner;

public class B1977 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int min = -1;
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i * i >= n && i * i <= m) {
                sum += i * i;
                if (min == -1) {
                    min = i * i;
                }
            }
        }
        if (min == -1) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}

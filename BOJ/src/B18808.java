//playtime = 05:23

import java.util.Scanner;

public class B18808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                sum += i + j;
            }
        }
        System.out.println(sum);
    }
}

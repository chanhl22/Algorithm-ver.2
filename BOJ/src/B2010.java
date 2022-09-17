//playtime = 08:02

import java.util.Scanner;

public class B2010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 1;

        for(int i = 0; i < n; i++) {
            sum += sc.nextInt();
        }
        sum -= n;
        System.out.println(sum);
    }
}

//playtime = 18:27

import java.util.Scanner;

public class B1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int ans = a % 10;
            for (int i = 1; i < b; i++) {
                ans = (ans * a) % 10;
            }
            if (ans == 0) {
                System.out.println(10);
            } else {
                System.out.println(ans);
            }
        }
    }
}

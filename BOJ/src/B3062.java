//playtime = 05:40

import java.util.Scanner;

public class B3062 {
    static int reverse(int num) {
        int result = 0;
        while (num != 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int num = sc.nextInt();
            int temp = reverse(num);
            int sum1 = num + temp;
            int sum2 = reverse(num + temp);
            if (sum1 == sum2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

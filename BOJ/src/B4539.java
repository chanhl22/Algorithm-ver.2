import java.util.Scanner;

public class B4539 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int num = sc.nextInt();
            int cnt = 0;
            int temp = num;
            while (temp > 0) {
                temp /= 10;
                cnt++;
            }
            double x = 1;
            for (int i = 1; i < cnt; i++) {
                x *= 10;
                num = (int)(Math.round(num / x) * x);
            }
            System.out.println(num);
        }
    }
}

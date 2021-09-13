import java.util.Scanner;

public class B2851 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = sc.nextInt();
        }
        int[] sum = new int[10];
        sum[0] = a[0];
        for (int i = 1; i < 10; i++) {
            sum[i] = sum[i-1] + a[i];
        }
        int down = 0;
        int up = 0;
        for (int i = 1; i < 10; i++) {
            if (sum[i] >= 100) {
                up = sum[i];
                down = sum[i - 1];
                break;
            }
            if (i == 9) {
                System.out.println(sum[i]);
                System.exit(0);
            }
        }
        if (up - 100 <= 100 - down) {
            System.out.println(up);
        } else {
            System.out.println(down);
        }
    }
}
import java.util.Scanner;

public class B2033 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int temp1 = 10;
        int temp2 = 1;
        while(temp1 < n) {
            int cal1 = n % temp1 / temp2;
            if (cal1 >= 5) {
                int cal2 = n / temp1;
                cal2 += 1;
                n = cal2 * temp1;
            } else {
                int cal2 = n / temp1;
                n = cal2 * temp1;
            }
            temp1 *= 10;
            temp2 *= 10;
        }
        System.out.println(n);
    }
}

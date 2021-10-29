import java.util.Scanner;

public class B22938 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x1 = sc.nextLong();
        long y1 = sc.nextLong();
        long r1 = sc.nextLong();
        long x2 = sc.nextLong();
        long y2 = sc.nextLong();
        long r2 = sc.nextLong();
        long temp1 = Math.abs(x1 - x2);
        long temp2 = Math.abs(y1 - y2);
        long len = temp1 * temp1 + temp2 * temp2;
        if ((r1 + r2) * (r1 + r2) <= len) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}

import java.util.Scanner;

public class B11068 {
    static boolean check(int n) {
        for (int b = 2; b <= 64; b++) {
            int number = n;
            String num1 = "";
            while (number > 0) {
                num1 += (char)(number % b);
                number = number / b;
            }
            StringBuilder num2 = new StringBuilder(num1);
            num2.reverse();
            if (num1.equals(num2.toString())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean ok = false;
            ok = check(n);
            if (ok) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}

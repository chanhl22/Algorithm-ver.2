import java.util.Scanner;

public class B1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String num = sc.next();
            if (num.equals("0")) {
                break;
            }
            boolean ok = true;
            for (int i = 0; i < num.length(); i++) {
                if (num.charAt(i) != num.charAt(num.length() - 1 - i)) {
                    ok = false;
                }
            }
            if (ok) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}

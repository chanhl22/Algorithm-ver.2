import java.util.Scanner;

public class B1212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for (int i = 0; i < s.length(); i++) {
            String a = Integer.toBinaryString(s.charAt(i) - '0');
            if (i != 0) {
                if (a.length() == 2) {
                    a = "0" + a;
                } else if (a.length() == 1) {
                    a = "00" + a;
                }
            }
            System.out.print(a);
        }
    }
}

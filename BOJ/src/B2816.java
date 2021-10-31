import java.util.Scanner;

public class B2816 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] ch = new String[n];
        int k1 = 0;
        int k2 = 0;
        for (int i = 0; i < n; i++) {
            ch[i] = sc.next();
            if (ch[i].equals("KBS1")) {
                k1 = i;
            }
            if (ch[i].equals("KBS2")) {
                k2 = i;
            }
        }
        if (k1 < k2) {
            for (int i = 0; i < k1; i++) {
                System.out.print(1);
            }
            for (int i = 0; i < k1; i++) {
                System.out.print(4);
            }
            for (int i = 0; i < k2; i++) {
                System.out.print(1);
            }
            for (int i = 0; i < k2 - 1; i++) {
                System.out.print(4);
            }
        } else {
            for (int i = 0; i < k1; i++) {
                System.out.print(1);
            }
            for (int i = 0; i < k1; i++) {
                System.out.print(4);
            }
            for (int i = 0; i < k2 + 1; i++) {
                System.out.print(1);
            }
            for (int i = 0; i < k2; i++) {
                System.out.print(4);
            }
        }
    }
}
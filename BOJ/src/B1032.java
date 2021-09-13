import java.util.Scanner;

public class B1032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }
        int len = str[0].length();
        String ans = "";
        for (int i = 0; i < len; i++) {
            char temp = str[0].charAt(i);
            boolean ok = true;
            for (int j = 0; j < n; j++) {
                if (temp != str[j].charAt(i)) {
                    ok = false;
                }
            }
            if (ok == false) {
                ans += "?";
            } else {
                ans += str[0].charAt(i);
            }
        }
        System.out.println(ans);
    }
}

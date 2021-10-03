import java.util.Scanner;

public class B4597 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.next();
            if (s.equals("#")) {
                break;
            }
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    cnt++;
                }
            }
            if (s.charAt(s.length() - 1) == 'e') {
                if (cnt % 2 == 0) {
                    s = s.replace("e", "0");
                } else if (cnt % 2 == 1) {
                    s = s.replace("e", "1");
                }
            } else if (s.charAt(s.length() - 1) == 'o') {
                if (cnt % 2 == 0) {
                    s = s.replace("o", "1");
                } else if (cnt % 2 == 1) {
                    s = s.replace("o", "0");
                }
            }
            System.out.println(s);
        }
    }
}

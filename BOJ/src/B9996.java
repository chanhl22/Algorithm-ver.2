import java.util.Scanner;

public class B9996 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        String[] s = str.split("\\*");
        while (n-- > 0) {
            String c = sc.next();
            int len1 = s[0].length();
            int len2 = s[1].length();
            if (c.length() < str.length() -1) {
                System.out.println("NE");
                continue;
            }
            String temp1 = c.substring(0, len1);
            String temp2 = c.substring(c.length() - len2);
            if (s[0].equals(temp1) && s[1].equals(temp2)) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}

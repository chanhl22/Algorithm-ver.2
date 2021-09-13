import java.util.Scanner;

public class B4458 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            char[] s = sc.nextLine().toCharArray();
            if (s[0] >= 'a' && s[0] <= 'z'){
                s[0] = (char)(s[0] - 32);
            }
            String str = String.valueOf(s);
            System.out.println(str);
        }
    }
}

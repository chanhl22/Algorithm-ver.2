//playtime = 05:23
import java.util.Scanner;

public class B2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(s.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}

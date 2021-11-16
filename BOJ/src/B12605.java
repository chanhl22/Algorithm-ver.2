//playtime = 02:47

import java.util.Scanner;

public class B12605 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        int x = 1;
        while(t-- > 0) {
            String str = sc.nextLine();
            String[] s = str.split(" ");
            String ans = "";
            for (int i = s.length - 1; i >= 0; i--) {
                ans += s[i] + " ";
            }
            System.out.println("Case #" + x + ": " + ans);
            x++;
        }
    }
}

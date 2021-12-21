//playtime = 36:03

import java.util.Scanner;

public class B1718 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ans = sc.nextLine();
        String key = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length(); i++) {
            char a = ans.charAt(i);
            if (a == ' ') {
                sb.append(' ');
            } else {
                int k = key.charAt(i % key.length()) - 96;
                sb.append((char)(a - k < 'a' ? a - k + 26 : a - k));
            }
        }
        System.out.println(sb.toString());
    }
}

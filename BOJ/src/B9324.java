/**
 * playtime = 27:24
 */

import java.util.Scanner;

public class B9324 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String input = sc.next();
            char[] alpha = new char[26];
            boolean flag = false;
            for (int i = 0; i < input.length(); i++) {
                char temp = input.charAt(i);
                alpha[input.charAt(i) - 'A']++;
                if (alpha[input.charAt(i) - 'A'] == 3) {
                    if (i + 1 >= input.length() || input.charAt(i + 1) != temp) {
                        flag = true;
                        break;
                    }
                    alpha[input.charAt(i) - 'A'] = 0;
                    i++;
                }
            }

            if (!flag) {
                System.out.println("OK");
            } else {
                System.out.println("FAKE");
            }
        }
    }
}

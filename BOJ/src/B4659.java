/**
 * playtime = 23:00
 */

import java.util.Scanner;

public class B4659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.next();
            if (input.equals("end")) {
                break;
            }
            if (checkCase1(input) && checkCase2(input) && checkCase3(input)) {
                System.out.println("<" + input + "> is acceptable.");
            } else {
                System.out.println("<" + input + "> is not acceptable.");
            }
        }
    }

    private static boolean checkCase1(String input) {
        boolean flag = false;
        for (int i = 0; i < input.length(); i++) {
            if (isVowel(input.charAt(i))) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    private static boolean checkCase2(String input) {
        int count = 1;
        char temp = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isVowel(temp) && isVowel(c)) {
                count++;
                if (count == 3) {
                    return false;
                }
            } else if (isVowel(temp) && isConsonant(c)) {
                count = 1;
            } else if (isConsonant(temp) && isConsonant(c)) {
                count++;
                if (count == 3) {
                    return false;
                }
            } else {
                count = 1;
            }
            temp = input.charAt(i);
        }
        return true;
    }

    private static boolean checkCase3(String input) {
        char temp = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (temp == 'e' || temp == 'o') {
                temp = input.charAt(i);
                continue;
            }
            if (temp == input.charAt(i)) {
                return false;
            }
            temp = input.charAt(i);
        }
        return true;
    }

    private static boolean isVowel(char temp) {
        return temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u';
    }

    private static boolean isConsonant(char temp) {
        return temp != 'a' && temp != 'e' && temp != 'i' && temp != 'o' && temp != 'u';
    }
}

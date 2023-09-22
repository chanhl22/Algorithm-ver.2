/**
 * playtime = 23:59
 */

import java.util.ArrayList;
import java.util.Scanner;

public class B5002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        String input = sc.next();
        ArrayList<Character> chars = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            chars.add(input.charAt(i));
        }

        int manCount = 0;
        int womanCount = 0;
        int result = 0;
        while (!chars.isEmpty()) {
            Character c1 = chars.remove(0);
            int tempManCount1 = manCount;
            int tempWomanCount1 = womanCount;
            if (c1 == 'M') {
                tempManCount1++;
            }
            if (c1 == 'W') {
                tempWomanCount1++;
            }

            if (Math.abs(tempManCount1 - tempWomanCount1) > x) {
                if (chars.isEmpty()) {
                    break;
                }
                Character c2 = chars.remove(0);
                int tempManCount2 = manCount;
                int tempWomanCount2 = womanCount;
                chars.add(0, c1);
                if (c2 == 'M') {
                    tempManCount2++;
                }
                if (c2 == 'W') {
                    tempWomanCount2++;
                }

                if (Math.abs(tempManCount2 - tempWomanCount2) > x) {
                    break;
                } else {
                    manCount = tempManCount2;
                    womanCount = tempWomanCount2;
                }
            } else {
                manCount = tempManCount1;
                womanCount = tempWomanCount1;
            }
            result++;
        }
        System.out.println(result);
    }
}

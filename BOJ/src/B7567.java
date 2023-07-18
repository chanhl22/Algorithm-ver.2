/**
 * playtime = 03:03
 */

import java.util.Scanner;

public class B7567 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dishes = sc.next();
        int len = 10;
        char beforeDish = dishes.charAt(0);
        for (int i = 1; i < dishes.length(); i++) {
            char dish = dishes.charAt(i);
            if (dish == beforeDish) {
                len += 5;
            } else  {
                len += 10;
                beforeDish = dish;
            }
        }
        System.out.println(len);
    }
}

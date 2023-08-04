/**
 * playtime = 03:46
 */

import java.time.LocalDate;
import java.util.Scanner;

public class B10768 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int day = sc.nextInt();
        LocalDate date = LocalDate.of(2015, month, day);
        LocalDate specialDate = LocalDate.of(2015, 2, 18);
        if (date.equals(specialDate)) {
            System.out.println("Special");
        } else if (date.isAfter(specialDate)) {
            System.out.println("After");
        } else {
            System.out.println("Before");
        }
    }
}

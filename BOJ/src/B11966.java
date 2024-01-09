/**
 * playtime = 10m 54s
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B11966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> numbers = new ArrayList<>();
        int max = 30;
        int index = 0;
        while (index <= max) {
            int pow = (int) Math.pow(2, index);
            numbers.add(pow);
            index++;
        }

        if (numbers.contains(n)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}

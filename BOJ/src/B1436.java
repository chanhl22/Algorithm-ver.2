/*
666, 1666, 2666, 3666, 4666, 5666, 6660, 6661, 6662, 6663,
6664, 6665, 6666, 6667, 6668, 6669, 7666, 8666, 9666, 10666,
11666, ~ 16660, 16661, ~16669
6번째 5666
7번째 6660
8번째 6661
17번째 7666
 */

import java.util.Scanner;

public class B1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = 1;
        int num = 666;
        while(c != n) {
            num++;
            if (Integer.toString(num).contains("666")) {
                c++;
            }
        }
        System.out.println(num);
    }
}

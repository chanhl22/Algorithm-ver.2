/**
 * playtime = 14:22
 */

import java.util.Scanner;

public class B2930 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        String me = sc.next();
        int n = sc.nextInt();
        String[] friends = new String[n];
        for (int i = 0; i < n; i++) {
            friends[i] = sc.next();
        }

        int count1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < r; j++) {
                count1 += diff(me.charAt(j), friends[i].charAt(j));
            }
        }
        System.out.println(count1);

        int count2 = 0;
        for (int i = 0; i < r; i++) {
            int result1 = 0;
            int result2 = 0;
            int result3 = 0;
            for (int j = 0; j < n; j++) {
                result1 += diff('R', friends[j].charAt(i));
                result2 += diff('S', friends[j].charAt(i));
                result3 += diff('P', friends[j].charAt(i));
            }
            count2 += Math.max(result1, Math.max(result2, result3));
        }
        System.out.println(count2);
    }

    private static int diff(char me, char friend) {
        if (me == 'S') {
            if (friend == 'P') {
                return 2;
            } else if (friend == 'S') {
                return 1;
            } else {
                return 0;
            }
        } else if (me == 'R') {
            if (friend == 'S') {
                return 2;
            } else if (friend == 'R') {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (friend == 'R') {
                return 2;
            } else if (friend == 'P') {
                return 1;
            } else {
                return 0;
            }
        }
    }
}

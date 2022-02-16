//playtime = 40:39

import java.util.Scanner;

public class B1034 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] map = new String[n];
        for (int i = 0; i < n; i++) {
            map[i] = sc.next();
        }
        int k = sc.nextInt();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int zero_count = 0;
            for (int j = 0; j < map[i].length(); j++) {
                if (map[i].charAt(j) == '0') {
                    zero_count++;
                }
            }
            if (k % 2 != zero_count % 2 || zero_count > k) {
                continue;
            }
            int check = 0;
            for (int j = 0; j < n; j++) {
                if (map[i].equals(map[j])) {
                    check++;
                }
            }
            if (max < check) {
                max = check;
            }
        }
        System.out.println(max);
    }
}
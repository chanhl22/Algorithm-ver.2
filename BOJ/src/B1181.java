//playtime = 20:30

import java.util.Arrays;
import java.util.Scanner;

public class B1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] word = new String[n];
        for (int i = 0; i < n; i++) {
            word[i] = sc.next();
        }
        Arrays.sort(word, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return o1.length() - o2.length();
            }
        });
        System.out.println(word[0]);
        for (int i = 1; i < n; i++) {
            if (!word[i-1].equals(word[i])) {
                System.out.println(word[i]);
            }
        }
    }
}

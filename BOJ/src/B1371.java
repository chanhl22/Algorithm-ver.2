/**
 * playtime = 37:12
 */

import java.util.Scanner;

public class B1371 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        while (sc.hasNext()) {
            text.append(sc.next());
        }
        int[] alpha = new int[26];
        for (int i = 0; i < text.length(); i++) {
            int i1 = text.charAt(i) - 'a';
            alpha[i1]++;
        }
        int max = 0;
        for (int j : alpha) {
            if (j >= max) {
                max = j;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] == max) {
                char c = (char) (i + 'a');
                result.append(c);
            }
        }
        System.out.println(result);
    }
}

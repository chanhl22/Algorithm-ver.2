/**
 * playtime = 17:40
 */

import java.util.Scanner;
import java.util.StringTokenizer;

public class B1343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        StringTokenizer st = new StringTokenizer(input, ".", true);
        StringBuilder result = new StringBuilder();
        while(st.hasMoreTokens()) {
            String s = st.nextToken();
            if (s.equals(".")) {
                result.append(".");
                continue;
            }
            int countA = s.length() / 4;
            for (int j = 0; j < countA; j++) {
                result.append("AAAA");
            }
            int countB = s.length() % 4;
            if (countB == 0) {
                continue;
            }
            if (countB % 2 == 0) {
                result.append("BB");
            } else {
                System.out.println("-1");
                return;
            }
        }
        System.out.println(result);
    }
}

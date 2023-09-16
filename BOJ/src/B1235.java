/**
 * playtime = 13:56
 */

import java.util.Arrays;
import java.util.Scanner;

public class B1235 {
    private static int n;
    private static String[] inputs;

    public static void main(String[] args) {
        input();
        solution();

    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        inputs = new String[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = sc.next();
        }
    }

    private static void solution() {
        int len = inputs[0].length();

        for (int index = len - 1; index >= 0; index--) {
            String[] temp = new String[n];
            for (int i = 0; i < n; i++) {
                temp[i] = inputs[i].substring(index);
            }

            Arrays.sort(temp);
            boolean flag = true;
            for (int i = 0; i < n - 1; i++) {
                if (temp[i].equals(temp[i + 1])) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println(temp[0].length());
                return;
            }
        }
    }
}

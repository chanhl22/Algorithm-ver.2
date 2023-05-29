/**
 * playtime = 38:58
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B6588 {
    private static final int N = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] check = new boolean[N + 1];
        check[0] = check[1] = true;
        for (int i = 2; i <= N; i++) {
            if (!check[i]) {
                for (int j = i + i; j <= N; j += i) {
                    check[j] = true;
                }
            }
        }

        while (true) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                break;
            }
            boolean flag = true;
            for (int i = 3; i <= input / 2; i += 2) {
                if (!check[i] && !check[input - i]) {
                    System.out.println(input + " = " + i + " + " + (input - i));
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }
}
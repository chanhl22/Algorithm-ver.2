/**
 * playtime = 33:12
 */

import java.util.Arrays;
import java.util.Scanner;

public class B26215 {
    private static int n;
    private static int[] snow;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        snow = new int[n];
        for (int i = 0; i < n; i++) {
            snow[i] = sc.nextInt();
        }
    }

    private static void solution() {
        int cnt = 0;
        while (!isEmpty()) {
            Arrays.sort(snow);
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (snow[i] != 0) {
                    snow[i]--;
                    index = i;
                    break;
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                if (snow[i] != 0 && index != i) {
                    snow[i]--;
                    break;
                }
            }
            cnt++;
        }

        if (cnt > 1440) {
            System.out.println(-1);
        } else {
            System.out.println(cnt);
        }
    }

    private static boolean isEmpty() {
        for (int i = 0; i < n; i++) {
            if (snow[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

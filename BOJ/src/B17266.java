/**
 * playtime = 38:36
 */

import java.util.Scanner;

public class B17266 {
    private static int n;
    private static int m;
    private static int[] position;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        position = new int[m];
        for (int i = 0; i < m; i++) {
            position[i] = sc.nextInt();
        }
    }

    private static void solution() {
        int dist = 0;
        int first = position[0];
        int last = n - position[m - 1];
        for (int i = 0; i < m - 1; i++) {
            if (dist < position[i + 1] - position[i]) {
                dist = position[i + 1] - position[i];
            }
        }

        int d = dist % 2 == 0 ? dist / 2 : (dist / 2) + 1;
        System.out.println(Math.max(Math.max(first, d), last));
    }
}

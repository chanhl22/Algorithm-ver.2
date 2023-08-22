/**
 * playtime = 07:19
 */

import java.util.Scanner;

public class B1817 {

    private static int n;
    private static int m;
    private static int[] weight;

    public static void main(String[] args) {
        input();

        solution();
    }

    private static void solution() {
        int count = 0;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + weight[i] <= m) {
                sum += weight[i];
            } else {
                sum = 0;
                i--;
                count++;
            }
        }

        System.out.println(sum != 0 ? count + 1 : count);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
    }
}

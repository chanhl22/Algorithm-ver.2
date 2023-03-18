/**
 * playtime = 23m 49s
 */

import java.util.Scanner;

public class B1173 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        int R = sc.nextInt();

        if (m + T > M) {
            System.out.println(-1);
            return;
        }

        int heart = m;
        int time = 0;
        int play = 0;
        while (play != N) {
            time++;
            heart += T;
            if (heart > M) {
                heart -= T;
                heart -= R;
                if (heart < m) {
                    heart = m;
                }
            } else {
                play++;
            }
        }

        System.out.println(time);
    }
}
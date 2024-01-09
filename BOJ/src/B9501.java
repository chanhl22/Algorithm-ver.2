/**
 * playtime = 14m 26s
 */

import java.util.Scanner;

public class B9501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int count = 0;
            int n = sc.nextInt();
            int d = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int v = sc.nextInt(); //속도
                int f = sc.nextInt(); //연료량
                int c = sc.nextInt(); //연소비율
                count += solution(d, v, f, c);
            }
            System.out.println(count);
        }
    }

    private static int solution(int d, int v, int f, int c) {
        // 총 움직일 수 있는 시간?
        double time = (double) f / (double) c;
        if ((double) d <= (double) v * time) {
            return 1;
        }
        return 0;
    }
}
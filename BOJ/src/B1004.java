//playtime = 26:31

import java.util.Scanner;

public class B1004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int n = sc.nextInt();
            int[][] planet = new int[n][3];
            for (int i = 0; i < n; i++) {
                planet[i][0] = sc.nextInt();
                planet[i][1] = sc.nextInt();
                planet[i][2] = sc.nextInt();
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                boolean ok1 = false;
                boolean ok2 = false;
                if (Math.pow(x1 - planet[i][0], 2) + Math.pow(y1 - planet[i][1], 2) < Math.pow(planet[i][2], 2)) {
                    ok1 = true;
                }
                if (Math.pow(x2 - planet[i][0], 2) + Math.pow(y2 - planet[i][1], 2) < Math.pow(planet[i][2], 2)) {
                    ok2 = true;
                }
                if (ok1 != true && ok2 == true || ok1 == true && ok2 != true) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
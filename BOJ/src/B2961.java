//playtime = 25:47

import java.util.Scanner;

class Cook2961 {
    int t1;
    int t2;

    public Cook2961(int t1, int t2) {
        this.t1 = t1;
        this.t2 = t2;
    }
}

public class B2961 {
    static Cook2961[] a;
    static int n;
    static int ans = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new Cook2961[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[i] = new Cook2961(x, y);
        }
        go(0, 1, 0);
        System.out.println(ans);
    }

    private static void go(int index, int first, int second) {
        if (index == n) {
            if (second != 0) {
                if (ans == -1 || ans > Math.abs(first - second)) {
                    ans = Math.abs(first - second);
                }
            }
            return;
        }
        go(index + 1, first * a[index].t1, second + a[index].t2);
        go(index + 1, first, second);
    }
}

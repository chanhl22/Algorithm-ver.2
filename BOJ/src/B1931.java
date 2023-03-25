//playtime : 22:05

import java.util.Arrays;
import java.util.Scanner;

class Pair1931 {
    int x;
    int y;

    public Pair1931(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class B1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair1931[] a = new Pair1931[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[i] = new Pair1931(x,y);
        }
        Arrays.sort(a, (o1, o2) -> {
            if(o1.y - o2.y == 0) {
                return o1.x - o2.x;
            } else {
                return o1.y - o2.y;
            }
        });
        int ans = 1;
        int s = a[0].y;
        for (int i = 1; i < n; i++) {
            if (a[i].x >= s) {
                s = a[i].y;
                ans++;
            }
        }
        System.out.println(ans);
    }
}

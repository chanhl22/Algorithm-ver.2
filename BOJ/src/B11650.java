//playtime = 5:00

import java.util.Arrays;
import java.util.Scanner;

class Pair34 {
    int x;
    int y;

    public Pair34(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class B11650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair34[] a = new Pair34[n];
        for (int i = 0; i < n; i++) {
            int nx = sc.nextInt();
            int ny = sc.nextInt();
            a[i] = new Pair34(nx, ny);
        }
        Arrays.sort(a, (o1, o2) -> {
            if (o1.x == o2.x) {
                return o1.y - o2.y;
            } else {
                return o1.x - o2.x;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(a[i].x + " " + a[i].y);
        }
    }
}

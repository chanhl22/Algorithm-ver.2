//playtime = 07:22

import java.util.Arrays;
import java.util.Scanner;

class Pair40 {
    int x;
    int y;

    public Pair40(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class B11651 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair40[] arr = new Pair40[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[i] = new Pair40(x, y);
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.y == o2.y) {
                return o1.x - o2.x;
            } else {
                return o1.y - o2.y;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i].x + " " + arr[i].y);
        }
    }
}
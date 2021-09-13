import java.util.Scanner;

class Pair33 {
    int x;
    int y;

    public Pair33(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class B10655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Pair33[] a = new Pair33[t];
        for (int i = 0; i < t; i++) {
            int input_x = sc.nextInt();
            int input_y = sc.nextInt();
            a[i] = new Pair33(input_x, input_y);
        }
        int[] dist = new int[t];
        int all = 0;
        for (int i = 1; i < t; i++) {
            dist[i-1] = Math.abs(a[i-1].x - a[i].x) + Math.abs(a[i-1].y - a[i].y);
            all += dist[i-1];
        }
        int ans = all;
        for (int i = 0; i < t-2; i++) {
            int temp = all;
            temp -= dist[i] + dist[i+1];
            ans = Math.min(ans, temp + Math.abs(a[i].x - a[i+2].x) + Math.abs(a[i].y - a[i+2].y));
        }
        System.out.println(ans);
    }
}

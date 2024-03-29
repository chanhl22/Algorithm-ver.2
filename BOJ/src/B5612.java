//playtime = 19:38

import java.util.Scanner;

class Tunnel5612 {
    int index;
    int s;
    int e;

    public Tunnel5612(int index, int s, int e) {
        this.index = index;
        this.s = s;
        this.e = e;
    }
}

public class B5612 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = sc.nextInt();
        Tunnel5612[] t = new Tunnel5612[n];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            t[i] = new Tunnel5612(i, s, e);
        }
        int max = count;
        for (int i = 0; i < n; i++) {
            count += t[i].s;
            count -= t[i].e;
            if (max < count) {
                max = count;
            }
            if (count < 0) {
                System.out.println("0");
                return;
            }
        }
        System.out.println(max);
    }
}

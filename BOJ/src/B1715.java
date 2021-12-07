//playtime = 57:03

import java.util.PriorityQueue;
import java.util.Scanner;

public class B1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Long> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.add(sc.nextLong());
        }
        int ans = 0;
        while (q.size() > 1) {
            Long t1 = q.poll();
            Long t2 = q.poll();
            Long t3 = t1 + t2;
            ans += t3;
            q.add(t3);
        }
        System.out.println(ans);
    }
}
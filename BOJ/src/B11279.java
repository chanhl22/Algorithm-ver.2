//playtime = 4:30

import java.util.PriorityQueue;
import java.util.Scanner;

public class B11279 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll() + "\n");
                } else {
                    sb.append(0 + "\n");
                }
            } else {
                pq.add(num);
            }
        }
        System.out.println(sb.toString());
    }
}

//playtime : 04:28

import java.util.PriorityQueue;
import java.util.Scanner;

public class B1927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> min = new PriorityQueue<>((o1, o2) -> o1 - o2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            if (input == 0) {
                if (min.isEmpty()) {
                    sb.append(0 + "\n");
                } else {
                    sb.append(min.poll() + "\n");
                }
            } else {
                min.add(input);
            }
        }
        System.out.println(sb.toString());
    }
}

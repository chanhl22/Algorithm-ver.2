/**
 * playtime = 08:15
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class B2161 {
    private static int n;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
    }

    private static void solution() {
        Deque<Integer> dq = init();

        while (dq.size() > 1) {
            throwAway(dq);
            move(dq);
        }

        System.out.println(dq.peek());
    }

    private static Deque<Integer> init() {
        Deque<Integer> dq = new LinkedList<>();
        for (int i = n; i >= 1; i--) {
            dq.add(i);
        }
        return dq;
    }

    private static void throwAway(Deque<Integer> dq) {
        System.out.print(dq.removeLast() + " ");
    }

    private static void move(Deque<Integer> dq) {
        dq.addFirst(dq.removeLast());
    }
}

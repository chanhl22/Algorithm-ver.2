/**
 * playtime = 5m 59s
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2164 {
    public static void main(String[] args) {
        int n = input();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while(true) {
            if (q.size() == 1) {
                System.out.println(q.peek());
                return;
            }
            cal1(q);
            cal2(q);
        }
    }

    private static void cal1(Queue<Integer> q) {
        q.remove();
    }

    private static void cal2(Queue<Integer> q) {
        Integer remove = q.remove();
        q.add(remove);
    }

    private static int input() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        return n;
    }
}

//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class B2164 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        Queue<Integer> q = new LinkedList<>();
//        for (int i = 1; i <= n; i++) {
//            q.add(i);
//        }
//        while(q.size() != 1) {
//            q.remove();
//            int back = q.remove();
//            q.add(back);
//        }
//        System.out.println(q.peek());
//    }
//}

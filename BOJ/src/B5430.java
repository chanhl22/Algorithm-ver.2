/**
 * playtime = 24m 40s
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class B5430 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solution();
        }
    }

    private static void solution() {
        String p = sc.next();
        int n = sc.nextInt();
        String array = sc.next();
        String[] num = array.substring(1, array.length() - 1).split(",");
        Deque<Integer> deque = new ArrayDeque<>();
        if (n != 0) {
            for (String s : num) {
                deque.addLast(Integer.parseInt(s));
            }
        }

        boolean reverse = false;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == 'R') {
                reverse = !reverse;
            } else {
                if (deque.isEmpty()) {
                    System.out.println("error");
                    return;
                }
                if (reverse) {
                    deque.removeLast();
                } else {
                    deque.removeFirst();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int size = deque.size();
        if (reverse) {
            for (int i = size - 1; i >= 0; i--) {
                sb.append(deque.removeLast());
                if (i != 0) {
                    sb.append(",");
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                sb.append(deque.removeFirst());
                if (i != size - 1) {
                    sb.append(",");
                }
            }
        }
        sb.append("]");
        System.out.println(sb);
    }
}

//import java.util.ArrayDeque;
//import java.util.Scanner;
//
//public class B5430 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while(t-- >0){
//            String command = sc.next();
//            int n = sc.nextInt();
//            String array = sc.next();
//            String[] num = array.substring(1,array.length()-1).split(",");
//            ArrayDeque<Integer> deque = new ArrayDeque<>();
//            for (int i = 0; i < n; i++) {
//                deque.add(Integer.parseInt(num[i]));
//            }
//            StringBuilder sb = new StringBuilder();
//            boolean ok = false;
//            boolean dir = true; //방향 체크 (정방향 : true), (역방향 : false)
//            for (int i = 0; i < command.length(); i++) {
//                if (command.charAt(i) == 'R') {
//                    dir = !dir;
//                } else if (command.charAt(i) == 'D') {
//                    if (dir) {
//                        if (deque.isEmpty()) {
//                            sb.append("error");
//                            System.out.println(sb.toString());
//                            ok = true;
//                            break;
//                        } else {
//                            deque.pollFirst();
//                        }
//                    } else {
//                        if (deque.isEmpty()) {
//                            sb.append("error");
//                            System.out.println(sb.toString());
//                            ok = true;
//                            break;
//                        } else {
//                            deque.pollLast();
//                        }
//                    }
//                }
//            }
//            if (ok) continue;
//            sb.append("[");
//            while (!deque.isEmpty()) {
//                if (dir) {
//                    sb.append(deque.pollFirst());
//                    if (!deque.isEmpty()) {
//                        sb.append(",");
//                    }
//                } else {
//                    sb.append(deque.pollLast());
//                    if (!deque.isEmpty()) {
//                        sb.append(",");
//                    }
//                }
//            }
//            sb.append("]");
//            System.out.println(sb.toString());
//        }
//    }
//}

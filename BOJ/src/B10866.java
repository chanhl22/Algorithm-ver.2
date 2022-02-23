//playtime = 13:03

import java.util.ArrayDeque;
import java.util.Scanner;

public class B10866 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        StringBuilder sb = new StringBuilder();
        for (int k=0; k<n; k++) {
            String line = sc.nextLine();
            String[] s = line.split(" ");
            String cmd = s[0];
            if (cmd.equals("push_front")) {
                int num = Integer.parseInt(s[1]);
                queue.offerFirst(num);
            } else if (cmd.equals("push_back")) {
                int num = Integer.parseInt(s[1]);
                queue.offerLast(num);
            }  else if (cmd.equals("front")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(queue.peekFirst()).append('\n');
                }
            } else if (cmd.equals("size")) {
                sb.append(queue.size()).append('\n');
            } else if (cmd.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else if (cmd.equals("pop_front")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(queue.pollFirst()).append('\n');
                }
            } else if (cmd.equals("pop_back")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(queue.pollLast()).append('\n');
                }
            } else if (cmd.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(queue.peekLast()).append('\n');
                }
            }
        }
        System.out.print(sb.toString());
    }
}
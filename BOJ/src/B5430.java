import java.util.ArrayDeque;
import java.util.Scanner;

public class B5430 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            String command = sc.next();
            int n = sc.nextInt();
            String array = sc.next();
            String[] num = array.substring(1,array.length()-1).split(",");
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(num[i]));
            }
            StringBuilder sb = new StringBuilder();
            boolean ok = false;
            boolean dir = true; //방향 체크 (정방향 : true), (역방향 : false)
            for (int i = 0; i < command.length(); i++) {
                if (command.charAt(i) == 'R') {
                    dir = !dir;
                } else if (command.charAt(i) == 'D') {
                    if (dir) {
                        if (deque.isEmpty()) {
                            sb.append("error");
                            System.out.println(sb.toString());
                            ok = true;
                            break;
                        } else {
                            deque.pollFirst();
                        }
                    } else {
                        if (deque.isEmpty()) {
                            sb.append("error");
                            System.out.println(sb.toString());
                            ok = true;
                            break;
                        } else {
                            deque.pollLast();
                        }
                    }
                }
            }
            if (ok) continue;
            sb.append("[");
            while (!deque.isEmpty()) {
                if (dir) {
                    sb.append(deque.pollFirst());
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                } else {
                    sb.append(deque.pollLast());
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
            }
            sb.append("]");
            System.out.println(sb.toString());
        }
    }
}

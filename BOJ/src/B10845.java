import java.util.Scanner;

public class B10845 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] queue = new int[n];
        int begin = 0;
        int end = 0;
        StringBuilder str = new StringBuilder();
        while (n-- > 0) {
            String cmd = sc.next();
            if (cmd.equals("push")) {
                int num = Integer.parseInt(sc.next());
                queue[end++ ] = num;
            } else if (cmd.equals("front")) {
                if (begin == end) {
                    str.append("-1");
                    str.append("\n");
                    //System.out.println("-1");
                } else {
                    str.append(queue[begin]);
                    str.append("\n");
                    //System.out.println(queue[begin]);
                }
            } else if (cmd.equals("size")) {
                str.append(end-begin);
                str.append("\n");
                //System.out.println(end-begin);
            } else if (cmd.equals("empty")) {
                if (begin == end) {
                    str.append("1");
                    str.append("\n");
                    //System.out.println("1");
                } else {
                    str.append("0");
                    str.append("\n");
                    //System.out.println("0");
                }
            } else if (cmd.equals("pop")) {
                if (begin == end) {
                    str.append("-1");
                    str.append("\n");
                    //System.out.println("-1");
                } else {
                    str.append(queue[begin]);
                    str.append("\n");
                    //System.out.println(queue[begin]);
                    begin += 1;
                }
            } else if (cmd.equals("back")) {
                if (begin == end) {
                    str.append("-1");
                    str.append("\n");
                    //System.out.println("-1");
                } else {
                    str.append(queue[end-1]);
                    str.append("\n");
                    //System.out.println(queue[end-1]);
                }
            }
        }
        System.out.println(str);
    }
}

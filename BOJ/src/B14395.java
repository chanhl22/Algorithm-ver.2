import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B14395 {
    final static long max = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        long t = sc.nextLong();

        //s == t
        if(s == t){
            System.out.println("0");
            System.exit(0);
        }

        //bfs
        HashSet<Long> check = new HashSet<>(); //dup check
        Queue<Long> q = new LinkedList<>();
        Queue<String> op = new LinkedList<>();
        check.add(s);
        q.add(s);
        op.add("");
        while(!q.isEmpty()){
            long x = q.remove();
            String ans = op.remove();
//            if (x == t) {
//                if (ans.length() == 0) {
//                    ans = "0";
//                }
//                System.out.println(ans);
//                System.exit(0);
//            }
            if(x == t) {
                System.out.println(ans);
                System.exit(0);
            }
            if (x*x >= 0 && x*x <= max && !check.contains(x*x)){
                check.add(x*x);
                q.add(x*x);
                op.add(ans + "*");
            }
            if (x+x >= 0 && x+x <= max && !check.contains(x+x)){
                check.add(x+x);
                q.add(x+x);
                op.add(ans + "+");
            }
            if (x-x >= 0 && x-x <= max && !check.contains(x-x)){
                check.add(x-x);
                q.add(x-x);
                op.add(ans + "-");
            }
            if (x != 0 && x/x >= 0 && x/x <= max && !check.contains(x/x)){
                check.add(x/x);
                q.add(x/x);
                op.add(ans + "/");
            }
        }
        System.out.println(-1);
    }
}

//playtime = 22:50

//별로 좋지 않은 코드...
//import java.util.PriorityQueue;
//import java.util.Scanner;
//
//class Minus {
//    int num;
//    boolean minus;
//
//    public Minus(int num, boolean minus) {
//        this.num = num;
//        this.minus = minus;
//    }
//}
//
//public class B11286 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        PriorityQueue<Minus> pq = new PriorityQueue<>((o1, o2) -> {
//            if (o1.num == o2.num) {
//                if (o1.minus == true) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//            } else {
//                return o1.num - o2.num;
//            }
//        });
//        StringBuilder sb = new StringBuilder();
//        while (n-- > 0) {
//            int num = sc.nextInt();
//            boolean ok = false;
//            if (num < 0) {
//                ok = true;
//            }
//            num = Math.abs(num);
//            if (num == 0) {
//                if (pq.isEmpty()) {
//                    sb.append(0).append('\n');
//                } else {
//                    Minus t = pq.remove();
//                    if (t.minus == true) {
//                        sb.append(-1 * t.num).append('\n');
//                    } else {
//                        sb.append(t.num).append('\n');
//                    }
//                }
//            } else {
//                pq.add(new Minus(num, ok));
//            }
//        }
//        System.out.println(sb.toString());
//    }
//}

//Best Solution
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B11286 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if(abs1 == abs2) return o1 > o2 ? 1 : -1;
            return abs1 - abs2;
        });

        for(int i = 0 ; i < n; i++){
            int val = Integer.parseInt(br.readLine());
            if(val == 0){
                if(queue.isEmpty()) System.out.println("0");
                else System.out.println(queue.poll());
            }else{
                queue.add(val);
            }
        }
    }
}
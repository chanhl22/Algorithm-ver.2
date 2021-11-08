//playtime = 1:00:01

import java.util.ArrayList;
import java.util.Scanner;

class Balloon {
    int index;
    int num;

    public Balloon(int index, int num) {
        this.index = index;
        this.num = num;
    }
}

public class B2346 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Balloon> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            b.add(new Balloon(i + 1, num));
        }
        StringBuilder sb = new StringBuilder();
        int s = 0;
        while (!b.isEmpty()) {
            sb.append(b.get(s).index + " ");
            int move = b.get(s).num;
            b.remove(s);
            if (b.isEmpty()) {
                break;
            }
            int size = b.size();
            if (move > 0) {
                move--;
                s = (s + move) % size;
            } else if (move < 0) {
                if (s + move < 0) {
                    int temp = (s + move) * -1;
                    s = (temp % size) * -1;
                } else {
                    s = (s + move) % size;
                }
                if (s < 0) {
                    s = s + size;
                }
            }
        }
        System.out.println(sb.toString());
    }
}

//Deque
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.Deque;
//import java.util.StringTokenizer;
//
//public class Main {
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringTokenizer st;
//    static StringBuffer sb = new StringBuffer();
//    static Deque<int[]> dq = new ArrayDeque<>();
//    static int N;
//
//    static void func() {
//        for (int i = 0; i < N; i++) {
//            int next = dq.peekFirst()[0];
//            sb.append(dq.peekFirst()[1] + " ");
//            dq.removeFirst();
//
//            if (dq.isEmpty())
//                break;
//
//            if (next > 0) {
//                next--;
//                while (next-- > 0) {
//                    dq.addLast(dq.peekFirst());
//                    dq.removeFirst();
//                }
//            } else {
//                while (next++ < 0) {
//                    dq.addFirst(dq.peekLast());
//                    dq.removeLast();
//                }
//            }
//        }
//
//        System.out.println(sb.toString());
//    }
//
//    static void input() throws Exception {
//        st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 1; i <= N; i++) {
//            dq.addLast(new int[] { Integer.parseInt(st.nextToken()), i });
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        input();
//        func();
//    }
//}
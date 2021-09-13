import java.util.Scanner;

public class B16953 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for (int i=1; a<=b; i++) {
            if (a == b) {
                System.out.println(i);
                System.exit(0);
            }
            if (b%10 == 1) {
                b = (b-1)/10;
            } else if (b%2 == 0) {
                b = b/2;
            } else {
                break;
            }
        }
        System.out.println(-1);
    }
}

//Add solution
//import java.util.*;
//public class Main {
//    static int go(long a, long b) {
//        if (a == b) return 1;
//        if (a > b) return -1;
//        int t1 = go(a*2, b);
//        int t2 = go(a*10+1, b);
//        if (t1 == -1 && t2 == -1) return -1;
//        if (t1 == -1) return t2+1;
//        if (t2 == -1) return t1+1;
//        return Math.min(t1,t2)+1;
//    }
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        long a = sc.nextLong();
//        long b = sc.nextLong();
//        System.out.println(go(a, b));
//    }
//}

//BFS로 풀면 메모리 초과가 발생
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class B16953 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//
//        int[] dist = new int[b + 1];
//        boolean[] check = new boolean[b + 1];
//        Queue<Integer> q = new LinkedList<>();
//        q.add(a);
//        dist[a] = 1;
//        check[a] = true;
//        while (!q.isEmpty()) {
//            int x = q.remove();
//            int nx = x * 2;
//            if (nx <= b) {
//                if (check[nx] == false) {
//                    dist[nx] = dist[x] + 1;
//                    check[nx] = true;
//                    q.add(nx);
//                }
//            }
//            int ny = x * 10 + 1;
//            if (ny <= b) {
//                if (check[ny] == false) {
//                    dist[ny] = dist[x] + 1;
//                    check[ny] = true;
//                    q.add(ny);
//                }
//            }
//        }
//        System.out.println(dist[b]);
//    }
//}
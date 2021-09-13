import java.util.Scanner;

class Teleport {
    long xs;
    long ys;
    long xe;
    long ye;

    public Teleport(long xs, long ys, long xe, long ye) {
        this.xs = xs;
        this.ys = ys;
        this.xe = xe;
        this.ye = ye;
    }
}

public class B12908 {
    static long dist(long xs, long ys, long xe, long ye) {
        return Math.abs(xs - xe) + Math.abs(ys - ye);
    }

    static long go(long xs, long ys, long xe, long ye, Teleport[] t) {
        long ans = dist(xs, ys, xe, ye);
        //텔포를 골라야하니까 재귀 순서
        for (int i = 0; i < t.length; i++) {
            Teleport[] tt = new Teleport[t.length - 1];
            for (int j = 0, k = 0; j < t.length; j++) {
                if (i == j) continue;
                tt[k++] = t[j];
            }
            long t1 = dist(xs, ys, t[i].xs, t[i].ys) + go(t[i].xe, t[i].ye, xe, ye, tt) + 10;
            long t2 = dist(xs, ys, t[i].xe, t[i].ye) + go(t[i].xs, t[i].ys, xe, ye, tt) + 10;
            if (ans > t1) ans = t1;
            if (ans > t2) ans = t2;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long xs = sc.nextLong();
        long ys = sc.nextLong();
        long xe = sc.nextLong();
        long ye = sc.nextLong();
        Teleport[] t = new Teleport[3];
        for (int i = 0; i < 3; i++) {
            long x1 = sc.nextLong();
            long y1 = sc.nextLong();
            long x2 = sc.nextLong();
            long y2 = sc.nextLong();
            t[i] = new Teleport(x1, y1, x2, y2);
        }
        System.out.println(go(xs, ys, xe, ye, t));
    }
}

//Code Refactoring
//import java.util.*;
//class Point {
//    int x, y;
//    Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
//class Teleport {
//    Point from;
//    Point to;
//    Teleport(Point from, Point to) {
//        this.from = from;
//        this.to = to;
//    }
//}
//public class Main {
//
//    public static long dist(Point p1, Point p2) {
//        return Math.abs(p1.x-p2.x) + Math.abs(p1.y-p2.y);
//    }
//    public static long go(Point start, Point end, Teleport[] t) {
//        long ans = dist(start, end);
//        for (int i=0; i<t.length; i++) {
//            Teleport[] ot = new Teleport[t.length-1];
//            for (int j=0, k=0; j<t.length; j++) {
//                if (i == j) continue;
//                ot[k++] = t[j];
//            }
//            long t1 = dist(start, t[i].from) + go(t[i].to, end, ot) + 10L;
//            long t2 = dist(start, t[i].to) + go(t[i].from, end, ot) + 10L;
//            if (ans > t1) ans = t1;
//            if (ans > t2) ans = t2;
//        }
//        return ans;
//    }
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        Point start = new Point(x, y);
//        x = sc.nextInt();
//        y = sc.nextInt();
//        Point end = new Point(x, y);
//        Teleport[] t = new Teleport[3];
//        for (int i=0; i<3; i++) {
//            int x1 = sc.nextInt();
//            int y1 = sc.nextInt();
//            int x2 = sc.nextInt();
//            int y2 = sc.nextInt();
//            t[i] = new Teleport(new Point(x1, y1), new Point(x2, y2));
//        }
//        System.out.println(go(start, end, t));
//    }
//}
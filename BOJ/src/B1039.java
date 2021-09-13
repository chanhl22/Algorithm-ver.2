import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1039 {
    static String num;
    static int n;
    static int k;
    static boolean[][] visit;

    static int swap(int num, int i, int j) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
        if (sb.charAt(0) == '0') {
            return -1;
        }
        return Integer.parseInt(sb.toString());
    }

    static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        q.add(0);
        visit[n][0] = true;
        int ans = -1;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            if (y == k) {
                if (ans < x) {
                    ans = x;
                }
                continue;
            }
            for (int i = 0; i < num.length(); i++) {
                for (int j = i + 1; j < num.length(); j++) {
                    int next = swap(x, i, j);
                    if (next == -1) continue;
                    if (visit[next][y + 1] == false) {
                        visit[next][y + 1] = true;
                        q.add(next);
                        q.add(y + 1);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.next();
        n = Integer.parseInt(num);
        k = sc.nextInt();
        visit = new boolean[1000001][k + 1];
        System.out.println(bfs());
    }
}

//메모리 초과
//import java.util.Scanner;
//
//public class B1039 {
//    static String n;
//    static int k;
//
//    static String swap(String num, int i, int j) {
//        StringBuilder sb = new StringBuilder(num);
//        sb.setCharAt(i, num.charAt(j));
//        sb.setCharAt(j, num.charAt(i));
//        return sb.toString();
//    }
//
//    static int go(int index, String num) {
//        if (index == k) {
//            return Integer.parseInt(num);
//        }
//        int ans = -1;
//        for (int i = 0; i < num.length(); i++) {
//            for (int j = 0; j < num.length(); j++) {
//                if (i == j) continue;
//                num = swap(num, i, j);
//                if (num.charAt(0) != '0') {
//                    int temp = go(index + 1, num);
//                    if (ans < temp) {
//                        ans = temp;
//                    }
//                }
//                num = swap(num, i, j);
//            }
//        }
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.next();
//        k = sc.nextInt();
//        System.out.println(go(0, n));
//    }
//}

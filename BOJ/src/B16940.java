import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16940 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] a = new ArrayList[n]; //�Է� ���� ����
        int[] parent = new int[n]; //y�� � x���� �Դ��� ����ϱ� ���� parent
        int[] order = new int[n]; //�Է� ���� bfs ����
        boolean[] check = new boolean[n]; //�湮 ���
        for (int i=0; i<n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i=0; i<n-1; i++) {
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            a[u].add(v);
            a[v].add(u);
        }
        for (int i=0; i<n; i++) {
            order[i] = sc.nextInt()-1;
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        check[0] = true;
        int m = 1; //ť�� ũ��
        for (int i=0; i<n; i++) {
            if (q.isEmpty()) {
                System.out.println(0);
                System.exit(0);
            }
            int x = q.remove();
            if (x != order[i]) {
                System.out.println(0);
                System.exit(0);
            }
            int cnt = 0;
            for (int y : a[x]) {
                if (check[y] == false) {
                    parent[y] = x;
                    cnt += 1;
                }
            }
            for (int j=0; j<cnt; j++) {
                if (m+j >= n || parent[order[m+j]] != x) {
                    System.out.println(0);
                    System.exit(0);
                }
                q.add(order[m+j]);
                check[order[m+j]] = true;
            }
            m += cnt;
        }
        System.out.println(1); 

    }
}


//import java.util.*;
//public class Main {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        ArrayList<Integer>[] a = new ArrayList[n];
//        int[] b = new int[n];
//        int[] order = new int[n];
//        boolean[] check = new boolean[n];
//        for (int i=0; i<n; i++) {
//            a[i] = new ArrayList<>();
//        }
//        for (int i=0; i<n-1; i++) {
//            int u = sc.nextInt()-1;
//            int v = sc.nextInt()-1;
//            a[u].add(v);
//            a[v].add(u);
//        }
//        for (int i=0; i<n; i++) {
//            b[i] = sc.nextInt()-1;
//            order[b[i]] = i;
//        }
//        for (int i=0; i<n; i++) {
//            Collections.sort(a[i], new Comparator<Integer>() {
//                public int compare(Integer u, Integer v) {
//                    if (order[u] < order[v]) {
//                        return -1;
//                    } else if (order[u] == order[v]) {
//                        return 0;
//                    } else {
//                        return 1;
//                    }
//                }
//            });
//        }
//        Queue<Integer> q = new LinkedList<>();
//        q.add(0);
//        check[0] = true;
//        ArrayList<Integer> bfs_order = new ArrayList<>();
//        while (!q.isEmpty()) {
//            int x = q.remove();
//            bfs_order.add(x);
//            for (int y : a[x]) {
//                if (check[y] == false) {
//                    check[y] = true;
//                    q.add(y);
//                }
//            }
//        }
//        boolean ok = true;
//        for (int i=0; i<n; i++) {
//            if (bfs_order.get(i) != b[i]) {
//                ok = false;
//            }
//        }
//        if (ok) {
//            System.out.println(1);
//        } else {
//            System.out.println(0);
//        }
//    }
//}





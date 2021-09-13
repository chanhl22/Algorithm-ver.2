import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Pair20 {
    int x;
    int y;

    public Pair20(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class B15686 {
    static int n;
    static int m;
    static int[][] a;
    static ArrayList<Pair20> people;
    static ArrayList<Pair20> store;
    static Stack<Pair20> select;
    static int ans = Integer.MAX_VALUE;

    static void cals() {
        int sum = 0;
        for (Pair20 p : people) {
            int min = Integer.MAX_VALUE;
            for (Pair20 s : select) {
                int dist = Math.abs(p.x - s.x) + Math.abs(p.y - s.y);
                min = Math.min(min, dist);
            }
            sum += min;
        }
        ans = Math.min(ans, sum);
    }

    static void go(int index, int pick) {
        if (pick == m) {
            cals();
            return;
        }
        if (index >= store.size()) {
            return;
        }
        select.push(store.get(index));
        go(index + 1, pick + 1);
        select.pop();
        go(index + 1, pick);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][n];
        people = new ArrayList<>();
        store = new ArrayList<>();
        select = new Stack<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 1) {
                    people.add(new Pair20(i, j));
                }
                if (a[i][j] == 2) {
                    store.add(new Pair20(i, j));
                }
            }
        }
        go(0, 0);
        System.out.println(ans);
    }
}


//Add Solution by permutation
//import java.util.*;
//class Pair {
//    int first;
//    int second;
//    Pair(int first, int second) {
//        this.first = first;
//        this.second = second;
//    }
//}
//public class Main {
//    static boolean next_permutation(int[] a) {
//        int i = a.length-1;
//        while (i > 0 && a[i-1] >= a[i]) {
//            i -= 1;
//        }
//
//        if (i <= 0) {
//            return false;
//        }
//
//        int j = a.length-1;
//        while (a[j] <= a[i-1]) {
//            j -= 1;
//        }
//
//        int temp = a[i-1];
//        a[i-1] = a[j];
//        a[j] = temp;
//
//        j = a.length-1;
//        while (i < j) {
//            temp = a[i];
//            a[i] = a[j];
//            a[j] = temp;
//            i += 1;
//            j -= 1;
//        }
//        return true;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[][] a = new int[n][n];
//        ArrayList<Pair> people = new ArrayList<>();
//        ArrayList<Pair> store = new ArrayList<>();
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                a[i][j] = sc.nextInt();
//                if (a[i][j] == 1) {
//                    people.add(new Pair(i,j));
//                } else if (a[i][j] == 2) {
//                    store.add(new Pair(i,j));
//                }
//            }
//        }
//        int[] d = new int[store.size()];
//        for (int i=0; i<m; i++) {
//            d[i] = 1;
//        }
//        Arrays.sort(d);
//        int ans = -1;
//        do {
//            int sum = 0;
//            for (Pair p : people) {
//                int min = -1;
//                for (int i=0; i<store.size(); i++) {
//                    if (d[i] == 0) continue;
//                    Pair s = store.get(i);
//                    int d1 = p.first-s.first;
//                    int d2 = p.second-s.second;
//                    if (d1 < 0) d1 = -d1;
//                    if (d2 < 0) d2 = -d2;
//                    int dist = d1+d2;
//                    if (min == -1 || min > dist) {
//                        min = dist;
//                    }
//                }
//                sum += min;
//            }
//            if (ans == -1 || ans > sum) {
//                ans = sum;
//            }
//        } while (next_permutation(d));
//        System.out.println(ans);
//    }
//}
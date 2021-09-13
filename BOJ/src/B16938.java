import java.util.Scanner;

public class B16938 {
    static int n;
    static int l;
    static int r;
    static int x;
    static int[] a;
    static boolean[] check;

    static int go(int index, int sum, int cnt) {
        int ans = 0;
        if (n == index) {
            int start = -1;
            int end = -1;
            for (int i = 0; i < n; i++) {
                if (check[i] == false) continue;
                if (start == -1 || start > a[i]) {
                    start = a[i];
                }
                if (end == -1 || end < a[i]) {
                    end = a[i];
                }
            }
            if (cnt >= 2 && sum >= l && sum <= r && end - start >= x) {
                return 1;
            } else {
                return 0;
            }
        }
        check[index] = true;
        ans += go(index + 1, sum + a[index], cnt + 1);
        check[index] = false;
        ans += go(index + 1, sum, cnt);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        x = sc.nextInt();
        a = new int[n];
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(go(0, 0, 0));
    }
}

//Refactoring code
//import java.util.*;
//public class B16938 {
//    static int n, l, r, x;
//    static int[] a = new int[15];
//    static boolean[] c = new boolean[15];
//    static int go(int index) {
//        if (index == n) {
//            int cnt = 0;
//            int sum = 0;
//            int hard = -1;
//            int easy = -1;
//            for (int i=0; i<n; i++) {
//                if (c[i] == false) continue;
//                sum += a[i];
//                cnt += 1;
//                if (hard == -1 || hard < a[i]) hard = a[i];
//                if (easy == -1 || easy > a[i]) easy = a[i];
//            }
//            if (cnt >= 2 && l <= sum && sum <= r && hard-easy >= x) return 1;
//            else return 0;
//        }
//        c[index] = true;
//        int cnt1 = go(index+1);
//        c[index] = false;
//        int cnt2 = go(index+1);
//        return cnt1+cnt2;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        l = sc.nextInt();
//        r = sc.nextInt();
//        x = sc.nextInt();
//        for (int i=0; i<n; i++) {
//            a[i] = sc.nextInt();
//        }
//        System.out.println(go(0));
//    }
//}

//Add Solution (Outstanding)
//import java.util.*;
//public class B16938 {
//    static int n, l, r, x;
//    static int[] a = new int[15];
//    static int go(int index, int cnt, int sum, int easy, int hard) {
//        if (index == n) {
//            if (cnt >= 2 && l <= sum && sum <= r && hard-easy >= x) return 1;
//            else return 0;
//        }
//        int cnt1 = go(index+1, cnt+1, sum+a[index], Math.min(easy,a[index]), Math.max(hard,a[index]));
//        int cnt2 = go(index+1, cnt, sum, easy, hard);
//        return cnt1+cnt2;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        l = sc.nextInt();
//        r = sc.nextInt();
//        x = sc.nextInt();
//        for (int i=0; i<n; i++) {
//            a[i] = sc.nextInt();
//        }
//        System.out.println(go(0, 0, 0, 1000000, 0));
//    }
//}
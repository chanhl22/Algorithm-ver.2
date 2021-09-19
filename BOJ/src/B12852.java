import java.util.Arrays;
import java.util.Scanner;

public class B12852 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n + 1]; // 최소 횟수 저장
        int[] v = new int[n + 1]; //경로 저장
        Arrays.fill(d, Integer.MAX_VALUE);//초기화

        d[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (d[i - 1] + 1 < d[i]) {
                d[i] = d[i - 1] + 1;
                v[i] = i - 1;
            }
            if (i % 2 == 0) {
                if (d[i / 2] + 1 < d[i]) {
                    d[i] = d[i / 2] + 1;
                    v[i] = i / 2;
                }
            }
            if (i % 3 == 0) {
                if (d[i / 3] + 1 < d[i]) {
                    d[i] = d[i / 3] + 1;
                    v[i] = i / 3;
                }
            }
        }
        System.out.println(d[n]);
        while (n > 0) {
            System.out.print(n + " ");
            n = v[n];
        }
    }
}

//import java.util.Scanner;
//
//public class B12852 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] d = new int[n + 1];
//        int[] v = new int[n + 1];
//        int[] a = new int[n + 1];
//        for (int i = 1; i < n + 1; i++) {
//            a[i] = i;
//        }
//        d[1] = 0;
//        v[1] = 0;
//        for (int i = 2; i < n + 1; i++) {
//            d[i] = d[i - 1] + 1;
//            if (i % 2 == 0) {
//                d[i] = Math.min(d[i], d[i / 2] + 1);
//            }
//            if (i % 3 == 0) {
//                d[i] = Math.min(d[i], d[i / 3] + 1);
//            }
//        }
//        for (int i = 2; i < n + 1; i++) {
//            if (d[i] == d[i - 1] + 1) {
//                v[i] = a[i - 1];
//            }
//            if (i % 2 == 0 && d[i] == d[i / 2] + 1) {
//                v[i] = a[i / 2];
//            }
//            if (i % 3 == 0 && d[i] == d[i / 3] + 1) {
//                v[i] = a[i / 3];
//            }
//        }
//        System.out.println(d[n]);
//        int[] s = new int[d[n]];
//        int p = n;
//        for (int i = 0; i < d[n]; i++) {
//            s[i] = a[p];
//            p = v[p];
//        }
//        for (int i = 0; i < s.length; i++) {
//            System.out.print(s[i] + " ");
//        }
//        System.out.println(1);
//    }
//}

//0 1 2 3 4 5 6 7 8 9 10 20 21 30 31 32 40 41 42
//마지막 감소하는 수 : 9876543210

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B1038 {
    static void go(long num, ArrayList<Long> a) {
        a.add(num);
        for (long i = 0; i < 10; i++) {
            if (num % 10 > i) {
                go((num * 10) + i, a);
            }
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Long> a = new ArrayList<>();
        if (n > 1022) {
            System.out.println(-1);
            System.exit(0);
        }
        for (int i = 0; i < 10; i++) {
            go(i, a);
        }
        Collections.sort(a);
        System.out.println(a.get(n));
    }
}

//정답은 나오나 시간초과
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class B1038 {
//    static boolean check (long n) {
//        long temp = 0;
//        while (n > 10) {
//            temp = n % 10;
//            n = n / 10;
//            if (temp >= n % 10) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        long[] a = new long[n+1];
//        Arrays.fill(a, -1);
//        long number = 0;
//        int i = 0;
//        while(i <= n) {
//            if (check(number)) {
//                a[i] = number;
//                i++;
//            }
//            number++;
//        }
//        System.out.println(a[n]);
//    }
//}

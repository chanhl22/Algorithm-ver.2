import java.util.Scanner;

public class B1357 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.next();
        String num2 = sc.next();
        StringBuilder sb1 = new StringBuilder(num1);
        sb1.reverse();
        StringBuilder sb2 = new StringBuilder(num2);
        sb2.reverse();
        int n1 = Integer.parseInt(sb1.toString());
        int n2 = Integer.parseInt(sb2.toString());
        int n3 = n1 + n2;
        String num3 = Integer.toString(n3);
        StringBuilder sb3 = new StringBuilder(num3);
        sb3.reverse();
        System.out.println(Integer.parseInt(sb3.toString()));
    }
}

//Another Solution
//import java.util.*;
//
//public class Main {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int X = sc.nextInt();
//        int Y = sc.nextInt();
//
//        sc.close();
//
//        int x = Rev(X);
//        int y = Rev(Y);
//        int res = Rev(x + y);
//        System.out.println(res);
//    }
//
//    private static int Rev(int N) {
//        String str = "";
//        while (N > 0) {
//            str += N % 10;
//            N /= 10;
//        }
//        return Integer.parseInt(str);
//    }
//}

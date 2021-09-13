import java.util.ArrayList;
import java.util.Scanner;

public class B2501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                a.add(i);
            }
        }
        if(a.size() < k) {
            System.out.println(0);
        } else {
            System.out.println(a.get(k-1));
        }
    }
}

//Another Solution
//import java.util.Scanner;
//
//public class Main {
//
//    static int N,K;
//    static Scanner sc = new Scanner(System.in);
//
//    public static void main(String[] args)  {
//        N = sc.nextInt();
//        K = sc.nextInt();
//
//        for (int i = 1; i <= N; i++) {
//            if(N % i == 0) K--;
//
//            if(K == 0) {
//                System.out.println(i);
//                break;
//            }
//        }
//        if(K != 0)
//            System.out.println(0);
//    }
//}
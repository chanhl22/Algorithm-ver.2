//playtime = 24:16

//import java.util.Scanner;
//
//public class B11328 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while (t-- > 0) {
//            String s1 = sc.next();
//            String s2 = sc.next();
//            int n = s1.length();
//            int m = s2.length();
//            if (n != m) {
//                System.out.println("Impossible");
//                continue;
//            }
//            boolean[] check1 = new boolean[n];
//            boolean[] check2 = new boolean[n];
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    if (check1[i] == false && check2[j] == false && s2.charAt(j) == s1.charAt(i)) {
//                        check1[i] = true;
//                        check2[j] = true;
//                    }
//                }
//            }
//            boolean ok = false;
//            for (int i = 0; i < n; i++) {
//                if (check1[i] == false) {
//                    System.out.println("Impossible");
//                    ok = true;
//                    break;
//                }
//            }
//            if (ok) {
//                continue;
//            }
//            System.out.println("Possible");
//        }
//    }
//}

//Another Best Solution
import java.util.*;

public class B11328 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int[] alpa = new int[26];
            char[] words1 = sc.next().toCharArray();
            char[] words2 = sc.next().toCharArray();
            for (char ch : words1) alpa[ch - 97]++;
            for (char ch : words2) alpa[ch - 97]--;
            boolean flag = true;
            for (int j : alpa) if (j != 0) flag = false;
            System.out.println(flag ? "Possible" : "Impossible");
        }
    }
}


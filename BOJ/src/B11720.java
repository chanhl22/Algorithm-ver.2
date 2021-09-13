import java.util.Scanner;

public class B11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String num = sc.next();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += num.charAt(i)-'0';
        }
        System.out.println(ans);
    }
}

//import java.util.Scanner;
//
//public class B11720 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String num = sc.next();
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = num.charAt(i)-'0';
//        }
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            ans += a[i];
//        }
//        System.out.println(ans);
//    }
//}

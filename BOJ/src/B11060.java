import java.util.Scanner;

public class B11060 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            d[i] = -1;
        }
        d[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (d[j] != -1 && i - j <= a[j]) {
                    if (d[i] == -1 || d[i] > d[j] + 1) {
                        d[i] = d[j] + 1;
                    }
                }
            }
        }
        System.out.println(d[n-1]);
    }
}

//import java.util.Scanner;
//
//public class B11060 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] a = new int[n];
//        int[] d = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//            d[i] = -1;
//        }
//        d[0] = 0;
//        for (int i = 0; i < n - 1; i++) {
//            if (d[i] == -1){
//                continue;
//            }
//            for (int j = 1; j <= a[i]; j++) {
//                if (i + j >= n) {
//                    break;
//                }
//                if (d[i + j] == -1 || d[i + j] > d[i] + 1) {
//                    d[i + j] = d[i] + 1;
//                }
//            }
//        }
//        System.out.println(d[n - 1]);
//    }
//}

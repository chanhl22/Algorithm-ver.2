import java.util.Scanner;

public class B16439 {
    static int n;
    static int m;
    static int[] chicken;
    static int[][] a;

    static int go(int index, int start) {
        int ans = 0;
        if (index == 3) {
            int ret = 0;
            for (int i = 0; i < n; i++) {
                int temp = 0;
                for (int j = 0; j < 3; j++) {
                    if (temp < a[i][chicken[j]]) {
                        temp = a[i][chicken[j]];
                    }
                }
                ret += temp;
            }
            return ret;
        }
        for (int i = start; i < m; i++) {
            chicken[index] = i;
            int temp = go(index + 1, i + 1);
            if (ans < temp) {
                ans = temp;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        chicken = new int[3];
        System.out.println( go(0, 0));
    }
}

//same code
//import java.util.Scanner;
//
//public class B16439 {
//    static int n;
//    static int m;
//    static int[] chicken;
//    static int[][] a;
//    static int ans = 0;
//
//    static void go(int index, int start) {
//        if (index == 3) {
//            int ret = 0;
//            for (int i = 0; i < n; i++) {
//                int temp = 0;
//                for (int j = 0; j < 3; j++) {
//                    if (temp < a[i][chicken[j]]) {
//                        temp = a[i][chicken[j]];
//                    }
//                }
//                ret += temp;
//            }
//            if (ans < ret) {
//                ans = ret;
//            }
//            return;
//        }
//        for (int i = start; i < m; i++) {
//            chicken[index] = i;
//            go(index + 1, i + 1);
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//        a = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                a[i][j] = sc.nextInt();
//            }
//        }
//        chicken = new int[3];
//        go(0, 0);
//        System.out.println(ans);
//    }
//}

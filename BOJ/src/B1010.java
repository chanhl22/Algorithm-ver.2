//playtime = 53:29

import java.util.Scanner;

public class B1010 {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            dp = new int[30][30];
            sb.append(go(m, n)).append('\n');
        }
        System.out.print(sb.toString());
    }

    private static int go(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }
        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }
        return dp[n][r] = go(n - 1, r - 1) + go(n - 1, r);
    }
}

//시간 초과
//import java.util.Scanner;
//
//public class B1010 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while (t-- > 0) {
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            System.out.println(go(n, m, 0, 0));
//        }
//    }
//
//    private static int go(int n, int m, int index, int start) {
//        if (index == n) {
//            return 1;
//        }
//        int sum = 0;
//        for (int i = start; i < m; i++) {
//            sum += go(n, m, index + 1, i + 1);
//        }
//        return sum;
//    }
//}
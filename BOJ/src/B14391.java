import java.util.Scanner;

public class B14391 {
    static int n;
    static int m;
    static int[][] a;
    static int[] d;
    static boolean[] record;

    static int cut() {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                if (record[i * m + j]) {
                    sum = 10 * sum + a[i][j];
                } else {
                    ans += sum;
                    sum = 0;
                }
            }
            ans += sum;
        }
        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (!record[i * m + j]) {
                    sum = 10 * sum + a[i][j];
                } else {
                    ans += sum;
                    sum = 0;
                }
            }
            ans += sum;
        }
        return ans;
    }

    static int go(int index) {
        if (index == n * m) {
            return cut();
        }
        record[index] = true; //row
        int t1 = go(index + 1);
        record[index] = false; //col
        int t2 = go(index + 1);
        return Math.max(t1, t2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        record = new boolean[n * m];
        d = new int[n * m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[(i * m) + j] = a[i][j];
            }
        }
        System.out.println(go(0));
    }
}


//Solution with bitmask
//import java.util.*;
//public class B14391 {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[][] a = new int[n][m];
//        for (int i=0; i<n; i++) {
//            String s = sc.next();
//            for (int j=0; j<m; j++) {
//                a[i][j] = s.charAt(j)-'0';
//            }
//        }
//        int ans = 0;
//        // 0: -, 1 : |
//        for (int s=0; s<(1<<(n*m)); s++) {
//            int sum = 0;
//            for (int i=0; i<n; i++) {
//                int cur = 0;
//                for (int j=0; j<m; j++) {
//                    int k = i*m+j;
//                    if ((s&(1<<k)) == 0) {
//                        cur = cur * 10 + a[i][j];
//                    } else {
//                        sum += cur;
//                        cur = 0;
//                    }
//                }
//                sum += cur;
//            }
//            for (int j=0; j<m; j++) {
//                int cur = 0;
//                for (int i=0; i<n; i++) {
//                    int k = i*m+j;
//                    if ((s&(1<<k)) != 0) {
//                        cur = cur * 10 + a[i][j];
//                    } else {
//                        sum += cur;
//                        cur = 0;
//                    }
//                }
//                sum += cur;
//            }
//            ans = Math.max(ans,sum);
//        }
//        System.out.println(ans);
//    }
//}
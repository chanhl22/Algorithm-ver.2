import java.util.Scanner;

public class B16945 {
    static boolean next(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i - 1] >= a[i]) {
            i -= 1;
        }
        if (i <= 0) {
            return false;
        }
        int j = a.length - 1;
        while (a[j] <= a[i - 1]) {
            j -= 1;
        }
        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        j = a.length - 1;
        while (i < j) {
            temp = a[j];
            a[j] = a[i];
            a[i] = temp;
            i++;
            j--;
        }
        return true;
    }

    static int diff(int[][] a, int[][] b) {
        int res = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                res += Math.abs(a[i][j] - b[i][j]);
            }
        }
        return res;
    }

    static boolean magic(int[] num, int[][] b) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                b[i][j] = num[cnt++];
            }
        }
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += b[i][j];
            }
            if (sum != 15) return false;
        }
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += b[j][i];
            }
            if(sum != 15) return false;
        }
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += b[i][i];
        }
        if (sum != 15) return false;
        sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += b[i][2-i];
        }
        if (sum != 15) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int[] num = new int[9];
        for (int i = 0; i < 9; i++) {
            num[i] = i + 1;
        }
        int[][] b = new int[3][3];
        int ans = -1;
        do {
            if (magic(num, b)) {
                int temp = diff(a, b);
                if (ans == -1 || ans > temp) {
                    ans = temp;
                }
            }
        } while (next(num));
        System.out.println(ans);
    }
}

//Another Solution (1차원 배열로 풀기)
//import java.util.*;
//public class Main {
//    final static int n = 3;
//    static boolean next_permutation(int[] a) {
//        int i = a.length-1;
//        while (i > 0 && a[i-1] >= a[i]) {
//            i -= 1;
//        }
//
//        if (i <= 0) {
//            return false;
//        }
//
//        int j = a.length-1;
//        while (a[j] <= a[i-1]) {
//            j -= 1;
//        }
//
//        int temp = a[i-1];
//        a[i-1] = a[j];
//        a[j] = temp;
//
//        j = a.length-1;
//        while (i < j) {
//            temp = a[i];
//            a[i] = a[j];
//            a[j] = temp;
//            i += 1;
//            j -= 1;
//        }
//        return true;
//    }
//    static boolean is_magic(int[] d) {
//        int magic = d[0*n+0] + d[0*n+1] + d[0*n+2];
//        for (int i=0; i<n; i++) {
//            int sum = 0;
//            for (int j=0; j<n; j++) {
//                sum += d[i*n+j];
//            }
//            if (magic != sum) return false;
//        }
//        for (int j=0; j<n; j++) {
//            int sum = 0;
//            for (int i=0; i<n; i++) {
//                sum += d[i*n+j];
//            }
//            if (magic != sum) return false;
//        }
//        if (magic != d[0*n+0] + d[1*n+1] + d[2*n+2]) return false;
//        if (magic != d[0*n+2] + d[1*n+1] + d[2*n+0]) return false;
//        return true;
//    }
//    static int diff(int[] a, int[] d) {
//        int ans = 0;
//        for (int i=0; i<n*n; i++) {
//            int temp = a[i] - d[i];
//            if (temp < 0) temp = -temp;
//            ans += temp;
//        }
//        return ans;
//    }
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int[] a = new int[n*n];
//        for (int i=0; i<n*n; i++) {
//            a[i] = sc.nextInt();
//        }
//        int[] d = new int[n*n];
//        for (int i=0; i<n*n; i++) {
//            d[i] = i+1;
//        }
//        int ans = -1;
//        do {
//            if (is_magic(d)) {
//                int cost = diff(a, d);
//                if (ans == -1 || ans > cost) {
//                    ans = cost;
//                }
//            }
//        } while(next_permutation(d));
//        System.out.println(ans);
//    }
//}


//Another solution
//import java.util.*;
//public class Main {
//    final static int n = 3;
//    static int[][] magic = {
//        {8, 1, 6, 3, 5, 7, 4, 9, 2},
//        {6, 1, 8, 7, 5, 3, 2, 9, 4},
//        {4, 3, 8, 9, 5, 1, 2, 7, 6},
//        {2, 7, 6, 9, 5, 1, 4, 3, 8},
//        {2, 9, 4, 7, 5, 3, 6, 1, 8},
//        {4, 9, 2, 3, 5, 7, 8, 1, 6},
//        {6, 7, 2, 1, 5, 9, 8, 3, 4},
//        {8, 3, 4, 1, 5, 9, 6, 7, 2}
//    };
//    static int diff(int[] a, int[] d) {
//        int ans = 0;
//        for (int i=0; i<n*n; i++) {
//            int temp = a[i] - d[i];
//            if (temp < 0) temp = -temp;
//            ans += temp;
//        }
//        return ans;
//    }
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int[] a = new int[n*n];
//        for (int i=0; i<n*n; i++) {
//            a[i] = sc.nextInt();
//        }
//        int ans = -1;
//        for (int[] d : magic) {
//            int cost = diff(a, d);
//            if (ans == -1 || ans > cost) {
//                ans = cost;
//            }
//        }
//        System.out.println(ans);
//    }
//}

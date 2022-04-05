//playtime = 47:38

import java.util.Scanner;

public class B11403 {
    static int n;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}

//시간 초과 발생 -> 100 * 100 * 10!
//import java.util.Scanner;
//
//public class B11403 {
//    static int n;
//    static int[][] map;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        map = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                map[i][j] = sc.nextInt();
//            }
//        }
//        int[][] answer = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                int count = 0;
//                if (go(i, j, count)) {
//                    answer[i][j] = 1;
//                } else {
//                    answer[i][j] = 0;
//                }
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(answer[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    private static boolean go(int start, int end, int count) {
//        if (count > n) {
//            return false;
//        }
//        if (count != 0 && start == end) {
//            return true;
//        }
//        boolean ret = false;
//        for (int i = 0; i < n; i++) {
//            if (map[start][i] == 1) {
//                ret = go(i, end, count + 1);
//                if (ret == true) break;
//            }
//        }
//        return ret;
//    }
//}

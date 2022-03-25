package question;

import java.util.ArrayList;
import java.util.Scanner;

public class SM2_1 {
    static int n;
    static int m;
    static int k;
    static int[][] result;
    static int max = 0;
    static ArrayList<Integer> list;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = sc.nextInt();
            }
        }
        list = new ArrayList<>();
        go(0, 0);
        System.out.println(max);
    }

    private static void go(int index, int select) {
        if (index == n || select > k) {
            return;
        }
        if (select == k) {
            check();
        }
        list.add(index);
        go(index + 1, select + 1);
        list.remove(list.size() - 1);
        go(index + 1, select);
    }

    private static void check() {
        int temp = 0;
        int[][] temp_result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp_result[i][j] = result[i][j];
            }
        }
        for (int k = 0; k < list.size(); k++) {
            for (int i = 0; i < n; i++) {
                temp_result[i][list.get(k)] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            boolean ok = false;
            for (int j = 0; j < m; j++) {
                if (temp_result[i][j] >= 5) {
                    ok = true;
                }
            }
            if (ok == true) {
                temp++;
            }
        }
        if (max < temp) {
            max = temp;
        }
    }
}
/**
 * playtime = 21:27
 */

import java.util.Scanner;

public class B1015 {
    static int n;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        visited = new boolean[n];
        int[] ans = new int[n];
        int index = 0;
        int num = 0;
        while(true) {
            if (checkArr()) {
                break;
            }
            for (int i = 0; i < n; i++) {
                if (arr[i] == index && !visited[i]) {
                    ans[i] = num;
                    num++;
                    visited[i] = true;
                }
            }
            index++;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    private static boolean checkArr() {
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ok = false;
            }
        }
        return ok;
    }
}

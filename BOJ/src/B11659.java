//playtime = 19:49

import java.util.Scanner;

public class B11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            d[i] = d[i - 1] + arr[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            sb.append(d[y] - d[x - 1]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
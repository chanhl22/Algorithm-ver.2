//playtime = 01:26:36

import java.util.Scanner;

public class B1205 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int score = sc.nextInt();
        int p = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int rank = 1;
        if (n >= p && score <= a[n - 1]) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < n; i++) {
                if (score < a[i]) {
                    rank++;
                } else {
                    break;
                }
            }
            System.out.println(rank);
        }
    }
}

//playtime = 3:56

import java.util.Scanner;

public class B1773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = sc.nextInt();
        }
        int ans = 0;
        for (int i = 1; i <= c; i++) {
            for (int j = 0; j < n; j++) {
                if (i % time[j] == 0) {
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}

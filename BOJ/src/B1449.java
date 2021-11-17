//playtime = 17:00

import java.util.Arrays;
import java.util.Scanner;

public class B1449 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int ans = 0;
        boolean[] check = new boolean[5000];
        for (int i = 0; i < n; i++) {
            if (check[a[i]] == false) {
                for (int j = a[i]; j < a[i] + l; j++) {
                    check[j] = true;
                }
                ans++;
            }
        }
        System.out.println(ans);
    }
}

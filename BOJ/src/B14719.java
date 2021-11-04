import java.util.Scanner;

public class B14719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }
        int ans = 0;
        for (int i = 1; i < m - 1; i++) {
            int right = a[i];
            int left = a[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(left, a[j]);
            }
            for (int j = i + 1; j < m; j++) {
                right = Math.max(right, a[j]);
            }
            if (a[i] < left && a[i] < right) {
                ans += Math.min(left, right) - a[i];
            }
        }
        System.out.println(ans);
    }
}

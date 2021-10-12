import java.util.Scanner;

public class B17608 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int high = 0;
        int ans = 0;
        for (int i = n-1; i >= 0; i--) {
            if (high < a[i]) {
                high = a[i];
                ans++;
            }
        }
        System.out.println(ans);
    }
}

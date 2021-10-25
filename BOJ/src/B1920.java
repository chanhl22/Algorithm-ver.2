import java.util.Arrays;
import java.util.Scanner;

public class B1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n - 1;
            int mid = 0;
            int ans = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (b[i] == a[mid]) {
                    ans = 1;
                    break;
                }
                if (b[i] < a[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(ans);
        }
    }
}

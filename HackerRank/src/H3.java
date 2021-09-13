import java.util.Scanner;

public class H3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a= new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            ans += a[i];
        }
        System.out.println(ans);
    }
}

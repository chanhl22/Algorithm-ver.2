import java.util.Scanner;

public class B1233 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s1 = sc.nextInt();
        int s2 = sc.nextInt();
        int s3 = sc.nextInt();
        int[] a = new int[s1 + s2 + s3 + 1];
        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                for (int k = 1; k <= s3; k++) {
                    a[i + j + k]++;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] < a[i]) {
                ans = i;
            }
        }
        System.out.println(ans);
    }
}

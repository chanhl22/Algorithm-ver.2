import java.util.Scanner;

public class B15989 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = 3;
            int[] nums = {1, 2, 3};
            int[] d = new int[n+1];
            d[0] = 1;
            for (int j = 0; j < m; j++) {
                for (int i = 1; i <= n; i++) {
                    if (i - nums[j] >= 0) {
                        d[i] += d[i - nums[j]];
                    }
                }
            }
            System.out.println(d[n]);
        }
    }
}

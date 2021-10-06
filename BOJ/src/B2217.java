import java.util.Arrays;
import java.util.Scanner;

public class B2217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        Arrays.sort(w);
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            int temp = w[i] * (n-i);
            if (max < temp) {
                max = temp;
            }
        }
        System.out.println(max);
    }
}

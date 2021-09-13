import java.util.Scanner;

public class B2293 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] d = new int[k+1];
        d[0] = 1;
        for (int j = 0; j < n; j++) {
            for (int i = 1; i <= k; i++) {
                if (i-a[j] >= 0){
                    d[i] += d[i-a[j]];
                }
            }
        }
        System.out.println(d[k]);
    }
}

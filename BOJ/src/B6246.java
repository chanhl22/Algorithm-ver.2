import java.util.Scanner;

public class B6246 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] start = new int[q];
        int[] interval = new int[q];
        boolean[] balloon = new boolean[n];
        for (int i = 0; i < q; i++) {
            start[i] = sc.nextInt();
            interval[i] = sc.nextInt();
        }
        for (int i = 0; i < q; i++) {
            for (int j = start[i] - 1; j < n; j += interval[i]) {
                balloon[j] = true;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (balloon[i] == false) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}

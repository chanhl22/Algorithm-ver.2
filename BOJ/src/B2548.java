import java.util.Scanner;

public class B2548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int ans = -1;
        int ans_num = a[0];
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                 temp += Math.abs(a[j] - a[i]);
            }
            if (ans == -1 || ans > temp) {
                ans = temp;
                ans_num = a[i];
            } else if (ans == temp) {
                if (ans_num > a[i]) {
                    ans_num = a[i];
                }
            }
        }
        System.out.println(ans_num);
    }
}

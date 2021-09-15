import java.util.Scanner;

public class B14912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = i;
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            String str = Integer.toString(a[i]);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) - '0' == d) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}

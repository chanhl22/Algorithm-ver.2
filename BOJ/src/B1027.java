import java.util.Scanner;

public class B1027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //a index : 빌딩 번호, a[] 값 : 빌딩 높이
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        int ans = 0;
        for (int c = 0; c < n; c++) {
            long y = a[c];
            int x = c;
            int cnt = 0;
            if (c != 0) {
                double g = y - a[x - 1];
                cnt++;
                for (int i = x - 1; i >= 0; i--) {
                    double next_g = (double)(y - a[i]) / (x - i);
                    if (g > next_g) {
                        cnt++;
                        g = next_g;
                    }
                }
            }
            if (c != n-1) {
                double g = a[x + 1] - y;
                cnt++;
                for (int i = x + 1; i < n; i++) {
                    double next_g = (double)(a[i] - y) / (i - x);
                    if (g < next_g) {
                        cnt++;
                        g = next_g;
                    }
                }
            }
            if (ans < cnt){
                ans = cnt;
            }
        }
        System.out.println(ans);
    }
}

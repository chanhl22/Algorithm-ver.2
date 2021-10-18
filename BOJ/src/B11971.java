import java.util.Scanner;

public class B11971 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] street1 = new int[100];
        int start = 0;
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            int s = sc.nextInt();
            for (int j = start; j < start + v; j++) {
                street1[j] = s;
            }
            start += v;
        }
        start = 0;
        int[] street2 = new int[100];
        for (int i = 0; i < m; i++) {
            int v = sc.nextInt();
            int s = sc.nextInt();
            for (int j = start; j < start + v; j++) {
                street2[j] = s;
            }
            start += v;
        }
        int ans = 0;
        for (int i = 0; i < 100; i++) {
            if (ans < street2[i] - street1[i]) {
                ans = street2[i] - street1[i];
            }
        }
        System.out.println(ans);
    }
}

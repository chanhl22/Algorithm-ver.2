import java.util.Scanner;

public class B9094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int cnt = 0;
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int i = 1; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((i * i + j * j + m) % (i * j) == 0) {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}

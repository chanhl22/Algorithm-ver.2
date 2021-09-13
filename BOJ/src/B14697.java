import java.util.Scanner;

public class B14697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int n = sc.nextInt();
        for (int i = 0; i <= n/a; i++) {
            for (int j = 0; j <= n/b; j++) {
                for (int k = 0; k <= n/c; k++) {
                    if (n == i*a + j*b + k*c) {
                        System.out.println(1);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(0);
    }
}

import java.util.Scanner;

public class B1816 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] prime = new boolean[1000001];
        for (int i = 2; i < 1000001; i++) {
            if (prime[i] == false) {
                for (int j = i + i; j < 1000001; j += i) {
                    prime[j] = true;
                }
            }
        }
        int t = sc.nextInt();
        while (t-- > 0) {
            long num = sc.nextLong();
            boolean ok = false;
            for (int i = 2; i < 1000001; i++) {
                if (prime[i] == false) {
                    if (num % i == 0) {
                        ok = true;
                        break;
                    }
                }
            }
            if (ok) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}

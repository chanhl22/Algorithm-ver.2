import java.util.Scanner;

public class B11502 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        boolean[] prime = new boolean[1001];
        for (int i = 2; i < 1001; i++) {
            if (prime[i] == false) {
                for (int j = i * i; j < 1001; j += i) {
                    prime[j] = true;
                }
            }
        }
        while (t-- > 0) {
            int num = sc.nextInt();
            boolean ok = false;
            for (int i = 2; i < 1001; i++) {
                if (num < i) continue;
                for (int j = 2; j < 1001; j++) {
                    if (num < j) continue;
                    for (int k = 2; k < 1001; k++) {
                        if (num < k) continue;
                        if (num == i + j + k) {
                            if (prime[i] == false && prime[j] == false && prime[k] == false) {
                                System.out.println(i + " " + j + " " + k);
                                ok = true;
                                break;
                            }
                        }
                    }
                    if (ok) break;
                }
                if (ok) break;
            }
            if(ok == false) {
                System.out.println(0);
            }
        }
    }
}

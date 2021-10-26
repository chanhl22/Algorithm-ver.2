import java.util.Scanner;

public class B1747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] prime = new boolean[2000001];
        for (int i = 2; i < 2000001; i++) {
            if (prime[i] == false) {
                for (int j = i + i; j < 2000001; j += i) {
                    prime[j] = true;
                }
            }
        }
        int n = sc.nextInt();
        int ans = 0;
        for (int i = 2; i < 2000001; i++) {
            if (i >= n) {
                if (prime[i] == false) {
                    String temp = Integer.toString(i);
                    StringBuilder sb = new StringBuilder(temp);
                    sb.reverse();
                    if (sb.toString().equals(temp)) {
                        ans = i;
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}

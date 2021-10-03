import java.util.Scanner;

public class B19941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        char[] a = new char[n];
        a = sc.next().toCharArray();
        boolean[] check = new boolean[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 'P') {
                for (int j = -k; j <= k; j++) {
                    if (i + j < 0 || i + j >= n) {
                        continue;
                    }
                    if (check[i + j] == false && a[i + j] == 'H') {
                        check[i + j] = true;
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}

import java.util.Scanner;

public class B5555 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();
        String[] str = new String[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
            str[i] += str[i];
            if (str[i].contains(s)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

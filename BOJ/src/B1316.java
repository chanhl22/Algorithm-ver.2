import java.util.Scanner;

public class B1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        while (n-- > 0) {
            String s = sc.next();
            boolean[] check = new boolean[26];
            boolean ok = false;
            for (int i = 0; i < s.length(); i++) {
                int temp = s.charAt(i) - 'a';
                if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                    continue;
                }
                if (check[temp] == false) {
                    check[temp] = true;
                } else {
                    ok = true;
                    break;
                }
            }
            if (ok) continue;
            cnt++;
        }
        System.out.println(cnt);
    }
}

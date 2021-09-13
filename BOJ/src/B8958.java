import java.util.Scanner;

public class B8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int ans = 0;
            int cnt = 1;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'O') {
                    ans += cnt;
                    cnt++;
                } else if (s.charAt(j) == 'X'){
                    cnt = 1;
                }
            }
            System.out.println(ans);
        }
    }
}

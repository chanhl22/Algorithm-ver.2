import java.util.Scanner;

public class B2596 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] alpha = {"000000", "001111", "010011", "011100",
                "100110", "101001", "110101", "111010"};
        int n = sc.nextInt();
        String str = sc.next();
        String ans = "";
        for (int i = 0; i < n; i++) {
            boolean ok = false;
            String temp = str.substring(i * 6, i * 6 + 6);
            for (int j = 0; j < 8; j++) {
                int cnt = 0;
                for (int k = 0; k < 6; k++) {
                    if (alpha[j].charAt(k) == temp.charAt(k)) {
                        cnt++;
                    }
                }
                if (cnt >= 5) {
                    ans += (char) (j + 'A');
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                System.out.println(i + 1);
                System.exit(0);
            }
        }
        System.out.println(ans);
    }
}

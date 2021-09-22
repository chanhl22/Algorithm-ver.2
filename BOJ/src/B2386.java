import java.util.Scanner;

public class B2386 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            String[] s = str.split(" ");
            if (s[0].charAt(0) == '#') {
                break;
            }
            int cnt = 0;
            for (int i = 1; i < s.length; i++) {
                for (int j = 0; j < s[i].length(); j++) {
                    if (s[i].charAt(j) == s[0].charAt(0)) {
                        cnt++;
                    }
                    if (s[i].charAt(j) + 32 == s[0].charAt(0)) {
                        cnt++;
                    }
                }
            }
            System.out.println(s[0].charAt(0) + " " + cnt);
        }
    }
}

import java.util.Scanner;

public class B3059 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str = sc.next();
            boolean[] alpha = new boolean[26];
            for (int i = 0; i < str.length(); i++) {
                alpha[str.charAt(i) - 'A'] = true;
            }
            int sum = 0;
            for (int i = 0; i < 26; i++) {
                if (alpha[i] == false) {
                    sum += i + 'A';
                }
            }
            System.out.println(sum);
        }
    }
}

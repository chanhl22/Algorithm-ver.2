import java.util.Scanner;

public class B2954 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'a' || sb.charAt(i) == 'e' || sb.charAt(i) == 'i' || sb.charAt(i) == 'o'|| sb.charAt(i) == 'u') {
                sb.deleteCharAt(i+1);
                sb.deleteCharAt(i+1);
            }
        }
        System.out.println(sb.toString());
    }
}

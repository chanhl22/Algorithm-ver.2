import java.util.Scanner;

public class B1159 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] str = new String[t];
        int[] first = new int[27];
        for (int i = 0; i < t; i++) {
            str[i] = sc.next();
            first[str[i].charAt(0) - 'a'] += 1;
        }
        boolean ok = false;
        for (int i = 0; i < 27; i++) {
            if (first[i] >= 5) {
                System.out.print((char)(i+'a'));
                ok = true;
            }
        }
        if (!ok) {
            System.out.println("PREDAJA");
        }
    }
}

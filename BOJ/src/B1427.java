import java.util.Arrays;
import java.util.Scanner;

public class B1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] a = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            a[i] = s.charAt(i) - '0';
        }
        Arrays.sort(a);
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.print(a[i]);
        }
    }
}

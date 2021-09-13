import java.util.Scanner;

public class B10988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String r = sb.toString();
        if (s.equals(r)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}

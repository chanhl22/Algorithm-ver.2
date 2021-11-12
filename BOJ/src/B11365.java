import java.util.Scanner;

public class B11365 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            if (str.equals("END")) {
                break;
            }
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            System.out.println(sb.toString());
        }
    }
}

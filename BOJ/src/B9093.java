import java.util.Scanner;

public class B9093 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while (n-- > 0) {
            String[] str = sc.nextLine().split(" ");
            for (int i = 0; i < str.length; i++) {
                StringBuilder sb = new StringBuilder(str[i]);
                sb.reverse();
                System.out.print(sb.toString() + " ");
            }
            System.out.println();
        }
    }
}

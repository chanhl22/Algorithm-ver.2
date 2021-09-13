import java.util.Scanner;

public class B5565 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        for (int i = 0; i < 9; i++) {
            int book = sc.nextInt();
            total -= book;
        }
        System.out.println(total);
    }
}

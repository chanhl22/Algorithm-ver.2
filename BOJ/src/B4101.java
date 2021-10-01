import java.util.Scanner;

public class B4101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x == 0 && y == 0) {
                break;
            }
            if (x > y) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}

import java.util.Scanner;

public class B1094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int stick = 64;
        int cnt = 0;
        while (x > 0) {
            if (x < stick) {
                stick /= 2;
            } else {
                cnt++;
                x -= stick;
            }
        }
        System.out.println(cnt);
    }
}
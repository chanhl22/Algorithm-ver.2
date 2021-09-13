import java.util.Scanner;

public class B10162 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int a = 0;
        int b = 0;
        int c = 0;
        while (input >= 300) {
            input -= 300;
            a++;
        }
        while (input >= 60) {
            input -= 60;
            b++;
        }
        while (input >= 10) {
            input -= 10;
            c++;
        }
        System.out.println(input == 0 ? a + " " + b + " " + c : -1);
    }
}

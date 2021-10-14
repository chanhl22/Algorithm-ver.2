import java.util.Scanner;

public class B17094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] a = new char[n];
        a = sc.next().toCharArray();
        int num = 0;
        int alpha = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == '2') {
                num++;
            } else {
                alpha++;
            }
        }
        if (num == alpha) {
            System.out.println("yee");
        } else if (num > alpha) {
            System.out.println("2");
        } else {
            System.out.println("e");
        }
    }
}

import java.util.Scanner;

public class B2490 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            int[] a = new int[4];
            int zero = 0;
            for (int j = 0; j < 4; j++) {
                a[j] = sc.nextInt();
                if (a[j] == 0) {
                    zero++;
                }
            }
            switch (zero) {
                case 1 :
                    System.out.println('A');
                    break;
                case 2 :
                    System.out.println('B');
                    break;
                case 3 :
                    System.out.println('C');
                    break;
                case 4 :
                    System.out.println('D');
                    break;
                case 0 :
                    System.out.println('E');
                    break;
            }
        }
    }
}

import java.util.Scanner;

public class B5355 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String[] str = sc.nextLine().split(" ");
            double n = Double.parseDouble(str[0]);
            for (int i = 1; i < str.length; i++) {
                if (str[i].equals("@")) {
                    n *= 3;
                } else if (str[i].equals("%")) {
                    n += 5;
                } else if (str[i].equals("#")) {
                    n -= 7;
                }
            }
            System.out.printf("%.2f\n", n);
        }
    }
}

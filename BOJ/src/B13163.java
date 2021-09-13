import java.util.Scanner;

public class B13163 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] str = s.split(" ");
            str[0] = "god";
            for (int j = 0; j < str.length; j++) {
                System.out.print(str[j]);
            }
            System.out.println();
        }
    }
}

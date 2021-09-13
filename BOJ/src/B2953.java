import java.util.Scanner;

public class B2953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[5][4];
        int win = 0;
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int temp = 0;
            for (int j = 0; j < 4; j++) {
                a[i][j] = sc.nextInt();
                temp += a[i][j];
            }
            if (sum < temp) {
                sum = temp;
                win = i;
            }
        }
        System.out.println(win + 1 + " " + sum);
    }
}

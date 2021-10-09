import java.util.Scanner;

public class B2455 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[4][2];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        int people = 0;
        for (int i = 0; i < 4; i++) {
            people += a[i][1];
            people -= a[i][0];
            if (ans < people) {
                ans = people;
            }
        }
        System.out.println(ans);
    }
}

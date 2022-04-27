//playtime = 59:54

import java.util.Scanner;

public class B19539 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        int sum = 0;
        int checkTwo = 0;
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
            sum += h[i];
            checkTwo += h[i] / 2;
        }
        if (sum % 3 == 0 && sum / 3 <= checkTwo) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

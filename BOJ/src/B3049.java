//playtime = 01:09:19

import java.util.Scanner;

public class B3049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = n * (n - 1) * (n - 2) * (n - 3) / 4 / 3 / 2;
        System.out.println(answer);
    }
}

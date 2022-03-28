//playtime = 02:15

import java.util.Scanner;

public class B2506 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] problem = new int[n];
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            problem[i] = sc.nextInt();
            if (problem[i] == 0) {
                count = 0;
            } else {
                count++;
            }
            sum += count;
        }
        System.out.println(sum);
    }
}

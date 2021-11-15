//playtime = 04:12

import java.util.Scanner;

public class B2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        long num = a * b * c;
        String s = Long.toString(num);
        int[] check = new int[10];
        for (int i = 0; i < s.length(); i++) {
            check[s.charAt(i) - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(check[i]);
        }
    }
}

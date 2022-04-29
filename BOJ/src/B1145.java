//playtime = 06:24

import java.util.Scanner;

public class B1145 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
        int number = 1;
        while(true) {
            int count = 0;
            for (int i = 0; i < 5; i++) {
                if (number % arr[i] == 0) {
                    count++;
                }
            }
            if (count >= 3) {
                break;
            }
            number++;
        }
        System.out.println(number);
    }
}

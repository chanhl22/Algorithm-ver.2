//playtime = 32:00

import java.util.Scanner;

public class B1292 {
    public static void main(String[] args) {
        int[] arr = new int[1001];
        int sum = 0;
        int index = 0;
        for (int i = 1;; i++) {
            for (int j = 0; j < i; j++) {
                sum += i;
                index++;
                if (index == 1001) {
                    break;
                }
                arr[index] = sum;
            }
            if (index == 1001) {
                break;
            }
        }
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt() - 1;
        int end = sc.nextInt();
        System.out.println(arr[end] - arr[start]);
    }
}
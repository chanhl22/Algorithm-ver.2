//playtime = 04:29

import java.util.Scanner;

public class B2475 {
    static final int NUM = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[NUM];
        for (int i = 0; i < NUM; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(answer(arr));
    }

    private static int answer(int[] arr) {
        int sum = 0;
        for (int i = 0; i < NUM; i++) {
            sum += arr[i] * arr[i];
        }
        return sum % 10;
    }
}

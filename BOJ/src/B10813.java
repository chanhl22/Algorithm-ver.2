/**
 * playtime = 04:24
 */

import java.util.Scanner;

public class B10813 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < m; i++) {
            int input1 = sc.nextInt() - 1;
            int input2 = sc.nextInt() - 1;

            int temp = arr[input1];
            arr[input1] = arr[input2];
            arr[input2] = temp;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

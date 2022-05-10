//playtime = 05:04

import java.util.Arrays;
import java.util.Scanner;

public class B4153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            boolean ok = true;
            int[] arr = new int[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] != 0) {
                    ok = false;
                }
            }
            if (ok) break;
            Arrays.sort(arr);
            if (arr[0] * arr[0] + arr[1] * arr[1] == arr[2] * arr[2]) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}

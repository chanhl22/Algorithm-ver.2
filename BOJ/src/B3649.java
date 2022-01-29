//playtime = 01:10:32

import java.util.Arrays;
import java.util.Scanner;

public class B3649 {
    static final int M = 10000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            int n = sc.nextInt();
            int[] block = new int[n];
            for (int i = 0; i < n; i++) {
                block[i] = sc.nextInt();
            }
            Arrays.sort(block);
            int left = 0;
            int right = n - 1;
            int ans1 = 0;
            int ans2 = 0;
            while (left < right) {
                if (block[left] + block[right] == x * M) {
                    ans1 = block[left];
                    ans2 = block[right];
                    break;
                } else if (block[left] + block[right] < x * M) {
                    left += 1;
                } else if (block[left] + block[right] > x * M)
                    right -= 1;
            }
            if (ans1 != 0 && ans2 != 0) {
                System.out.println("yes " + ans1 + " " + ans2);
            } else {
                System.out.println("danger");
            }
        }
    }
}
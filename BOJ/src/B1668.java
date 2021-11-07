//playtime = 7:20

import java.util.Scanner;

public class B1668 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int c1 = 1;
        int m1 = arr[0];
        for (int i = 0; i < n; i++) {
            if (m1 < arr[i]) {
                m1 = arr[i];
                c1++;
            }
        }
        int c2 = 1;
        int m2 = arr[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (m2 < arr[i]) {
                m2 = arr[i];
                c2++;
            }
        }
        System.out.println(c1);
        System.out.println(c2);
    }
}

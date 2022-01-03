//playtime = 09:29

import java.util.Scanner;

public class B2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = sc.nextInt();
        }
        boolean ok = true;
        for (int i = 0; i < 8; i++) {
            if (arr[i] != i + 1) {
                ok = false;
            }
        }
        if (ok) {
            System.out.println("ascending");
            return;
        }
        ok = true;
        for (int i = 0; i < 8; i++) {
            if (arr[i] != 8 - i) {
                ok = false;
            }
        }
        if (ok) {
            System.out.println("descending");
            return;
        }
        System.out.println("mixed");
    }
}

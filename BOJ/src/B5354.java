//playtime = 4:30

import java.util.Scanner;

public class B5354 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int num = sc.nextInt();
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    if (i == 0 || j == 0 || i == num - 1 || j == num - 1) {
                        System.out.print('#');
                    } else {
                        System.out.print('J');
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class B13140 {
    static int num;
    static int[] alpha;
    static boolean[] check;

    static void go(int index) {
        if (index == 7) {
            int first = alpha[2] * 10000 + alpha[1] * 1000 + alpha[3] * 100 + alpha[3] * 10 + alpha[4];
            int second = alpha[6] * 10000 + alpha[4] * 1000 + alpha[5] * 100 + alpha[3] * 10 + alpha[0];
            if (num == (first + second)) {
                System.out.println("  " + first);
                System.out.println("+ " + second);
                System.out.println("-------");
                if (num >= 100000) {
                    System.out.println(" " + num);
                } else {
                    System.out.println("  " + num);
                }
                System.exit(0);
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (check[i]) continue;
            if (index == 2 || index == 6) {
                if (i == 0) continue;
            }
            check[i] = true;
            alpha[index] = i;
            go(index + 1);
            alpha[index] = -1;
            check[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        alpha = new int[7];
        Arrays.fill(alpha, -1);
        check = new boolean[11];
        go(0);
        System.out.println("No Answer");
    }
}

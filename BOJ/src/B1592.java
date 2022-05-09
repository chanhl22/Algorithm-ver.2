//playtime = 20:43

import java.util.Scanner;

public class B1592 {
    static int n;
    static int m;
    static int l;
    static int[] countArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        l = sc.nextInt();

        // 3 <= N <= 50
        // M <= 50
        // L <= N - 1

        int count = 0;
        countArr = new int[n];
        int curPosition = 0;
        countArr[0] = 1;
        while (check()) {
            if (countArr[curPosition] % 2 == 0) {
                curPosition = (curPosition + n - l) % n;
            } else {
                curPosition = (curPosition + l) % n;
            }
            countArr[curPosition]++;
            count++;
        }
        System.out.println(count);
    }

    private static boolean check() {
        for (int i = 0; i < n; i++) {
            if (countArr[i] == m) {
                return false;
            }
        }
        return true;
    }
}

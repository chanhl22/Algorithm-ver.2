//playtime = 22:33

import java.util.Arrays;
import java.util.Scanner;

public class B5052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String[] numbers = new String[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = sc.next();
            }
            Arrays.sort(numbers);
            boolean ok = false;
            for (int i = 0; i < n - 1; i++) {
                if (numbers[i + 1].startsWith(numbers[i])) {
                    System.out.println("NO");
                    ok = true;
                    break;
                }
            }
            if (ok) continue;
            System.out.println("YES");
        }
    }
}

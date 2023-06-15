/**
 * playtime = 01:02:50
 */

import java.util.ArrayList;
import java.util.Scanner;

class Pair9576 {
    int a;
    int b;

    public Pair9576(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class B9576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean[] check = new boolean[n];
            ArrayList<Pair9576> pair = new ArrayList<>();
            int m = sc.nextInt();
            while (m-- > 0) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                pair.add(new Pair9576(a, b));
            }

            pair.sort((o1, o2) -> {
                if (o1.b == o2.b) {
                    return o2.a - o1.a;
                }
                return o1.b - o2.b;
            });

            int result = 0;
            for (Pair9576 pair9576 : pair) {
                for (int j = pair9576.a; j <= pair9576.b; j++) {
                    if (!check[j]) {
                        check[j] = true;
                        result++;
                        break;
                    }
                }
            }

            System.out.println(result);
        }
    }
}

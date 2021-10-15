import java.util.ArrayList;
import java.util.Scanner;

public class B9011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] r = new int[n];
            for (int i = 0; i < n; i++) {
                r[i] = sc.nextInt();
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            int[] s = new int[n];
            boolean ok = true;
            for (int i = n - 1; i >= 0; i--) {
                if (list.size() <= r[i]) {
                    ok = false;
                    break;
                } else {
                    s[i] = list.remove(r[i]);
                }
            }
            if (ok) {
                for (int i = 0; i < n; i++) {
                    System.out.print(s[i] + " ");
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}

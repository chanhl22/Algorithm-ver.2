import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class B4592 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(a[0]);
            for (int i = 1; i < n; i++) {
                if (a[i-1] != a[i]) {
                    ans.add(a[i]);
                }
            }
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println("$");
        }
    }
}

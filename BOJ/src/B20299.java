import java.util.ArrayList;
import java.util.Scanner;

public class B20299 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();
        int[] p1 = new int[n];
        int[] p2 = new int[n];
        int[] p3 = new int[n];
        for (int i = 0; i < n; i++) {
            p1[i] = sc.nextInt();
            p2[i] = sc.nextInt();
            p3[i] = sc.nextInt();
        }
        int cnt = 0;
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (p1[i] + p2[i] + p3[i] >= k) {
                if (p1[i] >= l && p2[i] >= l && p3[i] >= l) {
                    cnt++;
                    a.add(p1[i]);
                    a.add(p2[i]);
                    a.add(p3[i]);
                }
            }
        }
        System.out.println(cnt);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.size(); i++) {
            sb.append(a.get(i) + " ");
        }
        System.out.println(sb.toString());
    }
}

import java.util.*;

public class B10816 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if (map.containsKey(b[i])) {
                sb.append(map.get(b[i]) + " ");
            } else {
                sb.append(0 + " ");
            }
        }
        System.out.println(sb.toString());
    }
}

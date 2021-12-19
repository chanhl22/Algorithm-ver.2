import java.util.*;

public class SDS1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int tc = 1;
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            Deque<Integer> odd = new ArrayDeque<>();
            Deque<Integer> even = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if(a[i] % 2 == 0) {
                    even.add(a[i]);
                } else {
                    odd.add(a[i]);
                }
            }
            int ans = 0;
            while (!even.isEmpty()) {
                if (even.size() == 1) {
                    break;
                }
                ans += even.removeLast();
                even.remove();
            }
            while (!odd.isEmpty()) {
                if (odd.size() == 1) {
                    break;
                }
                ans += odd.removeLast();
                odd.remove();
            }
            if (even.size() == 1 && odd.size() == 1) {
                ans += Math.min(even.remove(), odd.remove());
            }
            System.out.println("#" + tc + " " + ans);
            tc++;
        }
    }
}

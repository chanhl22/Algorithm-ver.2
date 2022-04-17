//playtime = 24:52

import java.util.HashMap;
import java.util.Scanner;

public class B9375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int ans = 1;
            int n = sc.nextInt();
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String costume = sc.next();
                String kinds = sc.next();
                map.put(kinds, map.getOrDefault(kinds, 0) + 1);
            }
            for (Integer value : map.values()) {
                ans *= value + 1;
            }
            System.out.println(ans - 1);
        }
    }
}

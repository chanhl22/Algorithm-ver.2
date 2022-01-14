//playtime = 1:08:38

import java.util.Arrays;
import java.util.Scanner;

public class B2110 {
    static int n;
    static int c;
    static int[] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();
        map = new int[n];
        for (int i = 0; i < n; i++) {
            map[i] = sc.nextInt();
        }
        Arrays.sort(map);
        int left = 0;
        int right = map[n - 1];
        int mid = 0;
        while(left <= right) {
            mid = (left + right) / 2;
            if (check(mid) < c) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(right);
    }

    private static int check(int mid) {
        int cnt = 1;
        int last = map[0];
        for (int i = 1; i < n; i++) {
            int cur = map[i];
            if (cur - last >= mid) {
                cnt++;
                last = cur;
            }
        }
        return cnt;
    }
}

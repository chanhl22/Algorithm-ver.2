//playtime = 53:52

import java.util.Arrays;
import java.util.Scanner;

public class B2212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] sensor = new int[n];
        for (int i = 0; i < n; i++) {
            sensor[i] = sc.nextInt();
        }
        Arrays.sort(sensor);
        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = sensor[i + 1] - sensor[i];
        }
        Arrays.sort(diff);
        int ans = 0;
        for (int i = 0; i < (n - 1) - (k - 1); i++) {
            ans += diff[i];
        }
        System.out.println(ans);
    }
}

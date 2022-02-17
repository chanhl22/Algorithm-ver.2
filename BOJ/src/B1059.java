//playtime = 16:31

import java.util.Arrays;
import java.util.Scanner;

public class B1059 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int[] arr = new int[l];
        for (int i = 0; i < l; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int n = sc.nextInt();
        int index2 = 0;
        for (int i = 0; i < l; i++) {
            if (arr[i] > n) {
                index2 = i;
                break;
            }
        }
        int ans = 0;
        if (index2 == 0) {
            for (int i = 1; i < arr[index2]; i++) {
                if (i > n) break;
                for (int j = i + 1; j < arr[index2]; j++) {
                    if (j < n) continue;
                    ans++;
                }
            }
            System.out.println(ans);
        } else {
            int index1 = index2 - 1;
            for (int i = arr[index1] + 1; i < arr[index2]; i++) {
                if (i > n) break;
                for (int j = i + 1; j < arr[index2]; j++) {
                    if (j < n) continue;
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}

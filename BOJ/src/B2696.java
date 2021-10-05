import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B2696 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            sb.append(n/2 + 1 + "\n");
            int cnt = 0;
            ArrayList<Integer> temp2 = new ArrayList<>();
            for (int i = 0; i < n; i ++) {
                temp2.add(arr[i]);
                Collections.sort(temp2);
                if (i % 2 == 0) {
                    sb.append(temp2.get(i/2) + " ");
                    cnt++;
                    if (cnt % 10 == 0) {
                        sb.append("\n");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

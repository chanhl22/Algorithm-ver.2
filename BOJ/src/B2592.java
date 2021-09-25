import java.util.HashMap;
import java.util.Scanner;

public class B2592 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>(10);
        int[] a = new int[10];
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }
        System.out.println(sum/10);
        int ans = a[0];
        int temp1 = 0;
        for (int i = 0; i < 10; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
                int temp2 = map.get(a[i]) + 1;
                if (temp1 < temp2) {
                    temp1 = temp2;
                    ans = a[i];
                }
            } else {
                map.put(a[i], 1);
            }
        }
        System.out.println(ans);
    }
}

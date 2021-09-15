import java.util.Scanner;

public class B18429 {
    static int n;
    static int k;
    static int[] a;
    static boolean[] check;

    static int go(int index, int sum) {
        if (index == n) {
            if (sum < 500) {
                return 0;
            }
            return 1;
        }
        if (sum < 500) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (check[i] == true) continue;
            check[i] = true;
            ans += go(index + 1, sum + a[i] - k);
            check[i] = false;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //day
        k = sc.nextInt(); //minus
        a = new int[n]; //each day
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        check = new boolean[n];
        System.out.println(go(0, 500));
    }
}

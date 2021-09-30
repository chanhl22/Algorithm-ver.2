import java.util.Scanner;

public class B4256 {
    static int[] pre, in;

    static void post(int root, int s, int e) {
        int root_index = pre[root];
        for (int i = s; i < e; i++) {
            if (in[i] == root_index) {
                post(root + 1, s, i);
                post(root + i + 1 - s, i + 1, e);
                System.out.print(root_index + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            pre = new int[n + 1];
            in = new int[n + 1];
            for (int i = 0; i < n; i++) {
                pre[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                in[i] = sc.nextInt();
            }
            post(0, 0, n);
            System.out.println();
        }
    }
}

//playtime = 15:02

import java.util.Scanner;

public class B1717 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int zero_or_one = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (zero_or_one == 0) {
                unionParent(parent, a, b);
            } else {
                if (findParent(parent, a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static int getParent(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = getParent(parent, parent[x]);
    }

    private static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    private static boolean findParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if (a == b) {
            return true;
        }
        return false;
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SDS4 {
    static int n;
    static int m;
    static ArrayList<Integer>[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int tc = 1;
        while (t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            int start_a = sc.nextInt() - 1;
            int start_b = sc.nextInt() - 1;
            a = new ArrayList[m];
            for (int i = 0; i < m; i++) {
                a[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                a[x].add(y);
                a[y].add(x);
            }
            int[] ca = bfs(start_a);
            int[] cb = bfs(start_b);
            int ans = 0;
            System.out.println("#" + tc + " " + ans);
            tc++;
        }
    }

    private static int[] bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int[] check = new int[n];
        check[start] = 1;
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int y : a[x]) {
                if (check[y] == 0) {
                    check[y] = check[x] + 1;
                    q.add(y);
                }
            }
        }
        return check;
    }
}
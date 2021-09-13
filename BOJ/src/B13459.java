import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B13459 {
    static int n;
    static int m;
    static ArrayList<Integer>[] arr;

    static int bfs(int start) {
        int ret = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n];
        boolean[] check = new boolean[n];
        q.add(start);
        check[start] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int y : arr[x]) {
                if (check[y] == false) {
                    dist[y] = dist[x] + 1;
                    check[y] = true;
                    q.add(y);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            ret += dist[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            arr[a].add(b);
            arr[b].add(a);
        }
        int ans = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = bfs(i);
            if (result > temp) {
                result = temp;
                ans = i;
            }
        }
        System.out.println(ans + 1);
    }
}

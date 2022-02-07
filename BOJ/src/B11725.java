//playtime = 16:29

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B11725 {
    static int n;
    static int[] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Integer>[] tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            tree[x].add(y);
            tree[y].add(x);
        }
        bfs(tree);
    }

    private static void bfs(ArrayList<Integer>[] tree) {
        ans = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        while(!q.isEmpty()) {
            int cur = q.remove();
            for (int next : tree[cur]) {
                if (visited[next] == false) {
                    q.add(next);
                    visited[next] = true;
                    ans[next] = cur;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            System.out.println(ans[i]);
        }
    }
}

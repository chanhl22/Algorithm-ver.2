//playtime = 26:41

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B14496 {
    static int a;
    static int b;
    static int n;
    static int m;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();
        if (a == b) {
            System.out.println(0);
            return;
        }
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list[x].add(y);
            list[y].add(x);
        }
        System.out.println(bfs() == 0 ? -1 : bfs());
    }

    private static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        int[] visited = new int[n + 1];
        visited[a] = 0;
        while(!q.isEmpty()) {
            int cur = q.remove();
            for (int next : list[cur]) {
                if (visited[next] == 0) {
                    q.add(next);
                    visited[next] = visited[cur] + 1;
                }
            }
        }
        return visited[b];
    }
}
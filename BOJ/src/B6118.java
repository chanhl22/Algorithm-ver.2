//playtime = 27:06

import java.util.*;

public class B6118 {
    static int n;
    static int m;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }
        bfs();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);
        visited[1] = 0;
        while (!q.isEmpty()) {
            int now = q.remove();
            for (int next : list[now]) {
                if (visited[next] == -1) {
                    q.add(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int number = 0;
        int street = 0;
        for (int i = 1; i <= n; i++) {
            if (street < visited[i]) {
                number = i;
                street = visited[i];
            }
        }
        sb.append(number + "\n");
        sb.append(street + "\n");
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (street == visited[i]) {
                cnt++;
            }
        }
        sb.append(cnt);
        System.out.println(sb.toString());
    }
}

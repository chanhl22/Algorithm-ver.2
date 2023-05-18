//playtime = 01:48:41

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Weight1939 {
    int end;
    int weight;

    public Weight1939(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class B1939 {
    static int n;
    static int m;
    static ArrayList<Weight1939>[] list;
    static int s;
    static int e;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int dist = sc.nextInt();
            if (max < dist) {
                max = dist;
            }
            list[x].add(new Weight1939(y, dist));
            list[y].add(new Weight1939(x, dist));
        }
        s = sc.nextInt();
        e = sc.nextInt();
        int left = 0;
        int right = max;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (bfs(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }

    private static boolean bfs(int mid) {
        Queue<Weight1939> q = new LinkedList<>();
        q.add(new Weight1939(s, mid));
        boolean[] visited = new boolean[n + 1];
        visited[s] = true;
        while (!q.isEmpty()) {
            Weight1939 p = q.remove();
            int now = p.end;
            int now_weight = p.weight;
            for (Weight1939 weight : list[now]) {
                int next = weight.end;
                int next_weight = weight.weight;
                if (now_weight <= next_weight && visited[next] == false) {
                    q.add(new Weight1939(next, mid));
                    visited[next] = true;
                }
            }
        }
        if (visited[e]) {
            return true;
        } else {
            return false;
        }
    }
}